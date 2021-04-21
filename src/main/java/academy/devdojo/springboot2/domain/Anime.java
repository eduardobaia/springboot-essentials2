package academy.devdojo.springboot2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Anime {
    private Long Id;
    private String name;

    //Posso fazer tbm
    //add um anotation pra dizer que jo JSON vem X mas quero que meta esse X aqui no nomeCharacter
//    @JsonProperty("X")
//     private String nameCharacter;

}

