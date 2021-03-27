package academy.devdojo.springboot2.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Anime {

    private String name;

    public Anime(String name) {
        this.name = name;
    }

    public Anime() {
    }

}

