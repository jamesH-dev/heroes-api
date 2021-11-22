package com.dio.james.heroesapi.services;

import com.dio.james.heroesapi.models.HeroesModel;
import com.dio.james.heroesapi.repositories.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository){
        this.heroesRepository = heroesRepository;
    }

    public Flux<HeroesModel> findAll(){
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public Mono<HeroesModel> findById(String id){
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<HeroesModel> save(HeroesModel heroes){
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono <Boolean> deleteById(String id){
        heroesRepository.deleteById(id);
        return Mono.justOrEmpty(true);
    }
}
