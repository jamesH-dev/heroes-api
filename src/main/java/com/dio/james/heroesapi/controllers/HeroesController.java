package com.dio.james.heroesapi.controllers;

import com.dio.james.heroesapi.models.HeroesModel;
import com.dio.james.heroesapi.repositories.HeroesRepository;
import com.dio.james.heroesapi.services.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.dio.james.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {
    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
        this.heroesService = heroesService;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux <HeroesModel> getAllItems(){
        log.info("REQUESTING THE LIST OF ALL HEROES");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<HeroesModel>> findByIdHero(@PathVariable String id){
        log.info("REQUEST THE HERO WITH ID {}", id);
        return heroesService.findById(id)
                .map((item)-> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono <HeroesModel> createHero(@RequestBody HeroesModel heroes){
        log.info("A NEW HERO WAS CREATED");
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus (code = HttpStatus.CONTINUE)
    public Mono <HttpStatus> deleteByIdHero(@PathVariable String id){
        heroesService.deleteById(id);
        log.info("DELETING A HERO WITH ID {}", id);
        return Mono.justOrEmpty(HttpStatus.CONTINUE);
    }
}
