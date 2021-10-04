package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        //getForEntity Retorna o objeto dentro de um wrapper.
        ResponseEntity<Anime> entity= new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);
        log.info(entity);

        //getForObject Retorna o objeto diretamentw.
        Anime obj = new RestTemplate().getForObject("http://localhost:8080/animes/2", Anime.class);
        log.info(obj);


     ResponseEntity<List<Anime>> exchange=   new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET,null,
                new ParameterizedTypeReference<>() {});
        log.info(exchange.getBody());



//        Anime kingdom = Anime.builder().name("kingdom").build();
//
//     Anime kindgomSaved =  new RestTemplate().postForObject("http://localhost:8080/animes/", kingdom, Anime.class);
//     log.info("saved anime {}",kindgomSaved);

        Anime samurai = Anime.builder().name("samurai test").build();
        ResponseEntity<Anime> samuraiSaved =  new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.POST,
                new HttpEntity<>(samurai, creatJsonHeader()),
                Anime.class);
        log.info("saved anime {}",samuraiSaved);



    }

    private static HttpHeaders creatJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
