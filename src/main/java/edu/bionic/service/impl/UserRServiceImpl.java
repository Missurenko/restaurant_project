package edu.bionic.service.impl;

import edu.bionic.dao.UserRDao;

import edu.bionic.domain.my.Role;
import edu.bionic.domain.my.User;
import edu.bionic.dto.LoggedUser;

import edu.bionic.service.UserRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by bm on 27.08.17.
 */
@Service
public class UserRServiceImpl implements UserRService,UserDetailsService {

    private UserRDao userRDao;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRServiceImpl(UserRDao userRDao, PasswordEncoder passwordEncoder) {
        this.userRDao = userRDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User registerNewUser(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       User newUser = userRDao.save(user);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(new LoggedUser(newUser),
                        null,
                        Collections.singleton(user.getRole()));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return newUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRDao.getByEmail(username);
        return user.map(LoggedUser::new).orElse(null);
    }

    @Override
    public Optional<User> getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof LoggedUser) {
            return Optional.of(((LoggedUser) authentication.getPrincipal()).getUser());
        }
        return Optional.empty();
    }

}
