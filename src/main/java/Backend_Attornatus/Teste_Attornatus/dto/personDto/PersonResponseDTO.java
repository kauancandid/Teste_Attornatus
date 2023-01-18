package Backend_Attornatus.Teste_Attornatus.dto.personDto;


import Backend_Attornatus.Teste_Attornatus.dto.adressDto.AddressResponseDTO;
import Backend_Attornatus.Teste_Attornatus.model.AddressModel;
import Backend_Attornatus.Teste_Attornatus.model.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDTO {

    private UUID id;
    private String name;
    private String birthDate;
    private List<AddressResponseDTO> address = new ArrayList<>();

    public static PersonResponseDTO convertToDto(PersonModel address){
        var personResponseDTO = new PersonResponseDTO();

        personResponseDTO.setId(address.getId());
        personResponseDTO.setName(address.getName());
        personResponseDTO.setBirthDate(address.getBirthDate());

        for (AddressModel adress : address.getAddresses()) {
            personResponseDTO.getAddress().add(AddressResponseDTO.convertToDto(adress));
        }

        return personResponseDTO;
    }
}
