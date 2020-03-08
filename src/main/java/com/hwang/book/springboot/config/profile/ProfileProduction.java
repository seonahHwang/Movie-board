package com.hwang.book.springboot.config.profile;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@Profile(value="production")
@PropertySource({"classpath:production/application.properties"})
public class ProfileProduction {
}