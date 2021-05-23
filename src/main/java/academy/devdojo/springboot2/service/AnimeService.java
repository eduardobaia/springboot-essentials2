package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor  //pra o spring fazer a injecao de dependencia do animal repository
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return  animeRepository.findAll();
    }


    public Anime findByIdOrThrowBadRequestException(long id){
        return  animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody){
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
      return   animeRepository.save(anime);
    }

  public void delete(long id) {
       animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody) {
      Anime savedAnime=  findByIdOrThrowBadRequestException(animePutRequestBody.getId());
       Anime anime =  Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName()).build();
       animeRepository.save(anime);
    }
}
