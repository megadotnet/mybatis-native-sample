package com.example.mybatisnativesample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringJUnitConfig
@Transactional
public class CityMapperTest {
    
    @Autowired
    private CityMapper cityMapper;

    private City city;

    @BeforeEach
    public void setUp() {
        // Initialize a City object for testing
        city = new City();
        city.setName("TestCity");
        city.setState("TestState");
        city.setCountry("TestCountry");
    }

    @Test
    public void testInsertAndFindById() {
        // Insert the city into the database
        cityMapper.insert(city);

        // Ensure the ID was set by the database
        assertNotNull(city.getId());

        // Retrieve the city by its ID
        City retrievedCity = cityMapper.findById(city.getId());

        // Verify the retrieved city matches the inserted city
        assertNotNull(retrievedCity);
        assertEquals(city.getId(), retrievedCity.getId());
        assertEquals(city.getName(), retrievedCity.getName());
        assertEquals(city.getState(), retrievedCity.getState());
        assertEquals(city.getCountry(), retrievedCity.getCountry());
    }

    @Test
    public void testFindById_NonExistentId() {
        // Attempt to retrieve a city with a non-existent ID
        City retrievedCity = cityMapper.findById(999999L);

        // Verify that the retrieved city is null
        assertNull(retrievedCity);
    }

    @Test
    public void testDelById() {
        // Insert the city into the database
        cityMapper.insert(city);

        // Ensure the ID was set by the database
        assertNotNull(city.getId());

        // Delete the city by its ID
        Boolean deletionResult = cityMapper.delById(city.getId());

        // Verify the deletion was successful
        assertTrue(deletionResult);

        // Attempt to retrieve the deleted city
        City retrievedCity = cityMapper.findById(city.getId());

        // Verify that the retrieved city is null
        assertNull(retrievedCity);
    }

    @Test
    public void testDelById_NonExistentId() {
        // Attempt to delete a city with a non-existent ID
        Boolean deletionResult = cityMapper.delById(999999L);

        // Verify that the deletion result is false
        assertFalse(deletionResult);
    }

    @Test
    @Disabled
    public void testInsert_NullValues() {
        // Attempt to insert a city with null values
        city.setName(null);
        city.setState(null);
        city.setCountry(null);

        // Insert the city into the database
        assertThrows(Exception.class, () -> cityMapper.insert(city));
    }

    @Test
    public void testFindById_NegativeId() {
        // Attempt to retrieve a city with a negative ID
        City retrievedCity = cityMapper.findById(-1L);

        // Verify that the retrieved city is null
        assertNull(retrievedCity);
    }

    @Test
    public void testDelById_NegativeId() {
        // Attempt to delete a city with a negative ID
        Boolean deletionResult = cityMapper.delById(-1L);

        // Verify that the deletion result is false
        assertFalse(deletionResult);
    }
}