package Backend_Attornatus.Teste_Attornatus.dto.personDto;

import Backend_Attornatus.Teste_Attornatus.dto.adressDto.AddressRequestDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class PersonRequestDTO {

    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String name;

    @NotBlank(message = "O campo data de aniversário não pode ser vazio!")
    private String birthDate;

    @NotBlank(message = "O campo número não pode ser vazio!")
    private String number;

    @NotNull(message = "O campo cidade não pode ser vazio!")
    private AddressRequestDTO address;

}