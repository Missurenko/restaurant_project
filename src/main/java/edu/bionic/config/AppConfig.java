package edu.bionic.config;

import edu.bionic.dao.CommentDao;
import edu.bionic.dao.OrderDao;
import edu.bionic.dao.ProductDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"edu.bionic.service", "edu.bionic.presentation"})
public class AppConfig {


}
