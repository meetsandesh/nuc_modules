package com.nucleus.repositories;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nucleus.entity.score.parameters.ParameterCategory;


public interface ParameterCategoryRepository extends CrudRepository<ParameterCategory, Long>{
//	@Query("select c from ParameterCategory c where c.id = :id")
//    Stream<ParameterCategory>findParameterCategoryById(@Param("id") Long id);
}
