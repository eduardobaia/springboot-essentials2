package academy.devdojo.springboot2.requests;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {
    //DTO
    @NotNull(message = "The anime name shoun't be null" )
    @NotEmpty(message = "The anime name shoun't be empty" )
    private String name;
}
