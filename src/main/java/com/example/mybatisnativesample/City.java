package com.example.mybatisnativesample;

public class City {

// Private fields to store city information
  private Long id;
  private String name;
  private String state;
  private String country;

  // Getter method for the city ID
  public Long getId() {
    return this.id;
  }

  // Setter method for the city ID
  public void setId(Long id) {
    this.id = id;
  }

  // Getter method for the city name
  public String getName() {
    return this.name;
  }

  // Setter method for the city name
  public void setName(String name) {
    this.name = name;
  }

  // Getter method for the state
  public String getState() {
    return this.state;
  }

  // Setter method for the state
  public void setState(String state) {
    this.state = state;
  }

  // Getter method for the country
  public String getCountry() {
    return this.country;
  }

  // Setter method for the country
  public void setCountry(String country) {
    this.country = country;
  }

  // Override the toString method to provide a string representation of the City object
  @Override
  public String toString() {
    return getId() + "," + getName() + "," + getState() + "," + getCountry();
  }

}
