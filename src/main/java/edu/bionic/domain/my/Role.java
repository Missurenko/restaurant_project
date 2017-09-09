package edu.bionic.domain.my;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by bm on 25.08.17.
 */


public enum Role implements GrantedAuthority {
    ADMIN,
    USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
