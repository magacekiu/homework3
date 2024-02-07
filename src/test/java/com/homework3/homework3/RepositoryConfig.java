package com.homework3.homework3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.homework3.homework3.repository.DucksRepository;

@Configuration
public class RepositoryConfig {
    @Bean
    public DucksRepository ducksRepository() {
        return new DucksRepository();
    }
}