package Backend_Attornatus.Teste_Attornatus.dto.adressDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @NotBlank(message = "O campo Logradouro não pode ser vazio!")
    private String publicPlace;

    @NotBlank(message = "O campo cep não pode ser vazio!")
    private String postalCode;

    @NotBlank(message = "O campo número não pode ser vazio!")
    private String number;

    @NotBlank(message = "O campo cidade não pode ser vazio!")
    private String city;

    private boolean main;

}