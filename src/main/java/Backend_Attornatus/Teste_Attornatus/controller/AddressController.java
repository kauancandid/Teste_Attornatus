package Backend_Attornatus.Teste_Attornatus.controller;

import Backend_Attornatus.Teste_Attornatus.dto.adressDto.AddressResponseDTO;
import Backend_Attornatus.Teste_Attornatus.model.AddressModel;
import Backend_Attornatus.Teste_Attornatus.service.Impl.AddressServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "/address", produces="application/json")
public class AddressController {

    private AddressServiceImpl addressService;


    @ApiOperation("This method is used to save a address.")
    @PostMapping("/save/{personId}")
    public ResponseEntity<AddressResponseDTO> saveAddress(@RequestBody @Valid AddressModel personRequestDTO, @PathVariable String personId) {
        AddressModel addressModel = this.addressService.saveAddress(personRequestDTO, personId);
        return ResponseEntity.status(HttpStatus.CREATED).body(AddressResponseDTO.convertToDto(addressModel));
    }

    @ApiOperation("This method is used to list person by id")
    @GetMapping("/list-address-personId/{personId}")
    public ResponseEntity<List<AddressResponseDTO>> listAddressBypersonId(@PathVariable String personId) {
        List<AddressModel> addressModelList = this.addressService.listAllAddressByPersonId(personId);
        List<AddressResponseDTO> clientCardListResponse = new ArrayList<>();

        for (AddressModel addressCardModel : addressModelList) {
            clientCardListResponse.add(AddressResponseDTO.convertToDto(addressCardModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(clientCardListResponse);

    }

    @ApiOperation("This method is used to list all person.")
    @GetMapping("/list-address-main-personId/{personId}")
    public ResponseEntity<AddressResponseDTO> listAddressMain(@PathVariable String personId) {
        AddressModel addressModel = this.addressService.listAddressMainByPersonId(personId);
        return ResponseEntity.status(HttpStatus.CREATED).body(AddressResponseDTO.convertToDto(addressModel));
    }
}