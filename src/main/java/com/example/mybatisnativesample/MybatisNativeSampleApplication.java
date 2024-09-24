package com.example.mybatisnativesample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
public class MybatisNativeSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisNativeSampleApplication.class, args);
  }

  private final CityMapper cityMapper;

  // Constructor for MybatisNativeSampleApplication class
    // Injects the CityMapper dependency
    public MybatisNativeSampleApplication(CityMapper cityMapper) {
      // Assign the injected CityMapper to the class field
      this.cityMapper = cityMapper;
    }

  @Bean
  CommandLineRunner sampleCommandLineRunner() {
    return args -> {
      City city = new City();
      city.setName("BeiJing");
      city.setState("CA");
      city.setCountry("US");
      cityMapper.insert(city);
      System.out.println("Server:"+this.cityMapper.findById(city.getId()));
    };
  }

}