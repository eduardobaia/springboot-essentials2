package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AnimeRepositoryTest {


     private AnimeRepository animeRepository;

     @Test
     void test(){

     }


     private Anime createAnime(){
          return Anime.builder()
                  .name("Dead note")
                  .build();
     }

}
