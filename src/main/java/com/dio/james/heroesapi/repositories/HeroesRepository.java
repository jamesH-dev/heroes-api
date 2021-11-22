package com.dio.james.heroesapi.repositories;

import com.dio.james.heroesapi.models.HeroesModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends CrudRepository <HeroesModel, String> {

}
