package net.croz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CustomerDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerDemoApplication.class, args);
  }

  @Bean
  public WebMvcConfigurerAdapter webConfiguration() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
      }
    };
  }
}
