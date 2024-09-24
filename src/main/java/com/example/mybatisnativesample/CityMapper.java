package com.example.mybatisnativesample;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

  /**
   * Inserts a new city into the database.
   * The generated key (id) will be set back to the provided City object.
   *
   * @param city The City object to be inserted.
   */
  @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(City city);

  /**
   * Retrieves a city from the database by its ID.
   *
   * @param id The ID of the city to retrieve.
   * @return The City object corresponding to the given ID.
   */
  @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
  City findById(long id);


  /**
     * Deletes a city from the database by its ID.
     *
     * @param id The ID of the city to delete.
     * @return true if the deletion was successful, false otherwise.
     */
    @Delete("DELETE FROM city WHERE id = #{id}")
    Boolean delById(long id);

}