package Backend_Attornatus.Teste_Attornatus.dto.adressDto;


import Backend_Attornatus.Teste_Attornatus.model.AddressModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class AddressResponseDTO {

    private UUID id;
    private String publicPlace;
    private String postalCode;
    private String number;
    private String city;
    private boolean main;

    public static AddressResponseDTO convertToDto(AddressModel address){
        var addressResponseDTO = new AddressResponseDTO();

        addressResponseDTO.setId(address.getId());
        addressResponseDTO.setPublicPlace(address.getPublicPlace());
        addressResponseDTO.setPostalCode(address.getPostalCode());
        addressResponseDTO.setNumber(address.getNumber());
        addressResponseDTO.setCity(address.getCity());
        addressResponseDTO.setMain(address.isMain());
        return addressResponseDTO;
    }
}
