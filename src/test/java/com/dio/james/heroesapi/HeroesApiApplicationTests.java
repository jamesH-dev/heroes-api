package com.dio.james.heroesapi;

import com.dio.james.heroesapi.repositories.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.dio.james.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@AutoConfigureWebTestClient
class HeroesApiApplicationTests {

	@Autowired
	WebTestClient webTestCliente;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	public void getOneHeroById() {
		webTestCliente.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), 10)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneHeroByIdNotFound(){
		webTestCliente.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), 55)
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteHero(){
		webTestCliente.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), 1)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

}
