package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    void test() {

    }

    @Test
    void save_PersistAnime_whenSucess() {
        Anime anime = createAnime();
        Anime animeSaved= this.animeRepository.save(anime);

        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(anime.getName());
    }

    @Test
    void delete_removeAnime_whenSucess() {
        Anime anime = createAnime();
        Anime animeSaved= this.animeRepository.save(anime);

        this.animeRepository.delete(animeSaved);

        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());

        Assertions.assertThat(animeOptional.isEmpty()).isTrue();


    }

    private Anime createAnime() {
        return Anime.builder()
                .name("Dead note")
                .build();
    }

}
