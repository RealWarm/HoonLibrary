package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@EnableAspectJAutoProxy
@SpringBootApplication
public class LibraryAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(LibraryAppApplication.class, args);
  }

  @Bean
  public AuditorAware<String> auditorProvider(){
    AuditorAware<String> stringAuditorAware = () -> Optional.of(UUID.randomUUID().toString());
    return stringAuditorAware;
  }
}
