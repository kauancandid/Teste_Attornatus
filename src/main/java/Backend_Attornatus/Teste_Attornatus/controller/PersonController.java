package Backend_Attornatus.Teste_Attornatus.controller;

import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonRequestDTO;
import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonResponseDTO;
import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonUpdateDTO;
import Backend_Attornatus.Teste_Attornatus.model.PersonModel;
import Backend_Attornatus.Teste_Attornatus.service.Impl.PersonServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "/person", produces="application/json")
public class PersonController {

    private PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @ApiOperation("This method is used to save a person.")
    @PostMapping()
    public ResponseEntity<PersonResponseDTO> savePerson(@RequestBody @Valid PersonRequestDTO personRequestDTO) {
        PersonModel personModel = this.personService.savePerson(personRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponseDTO.convertToDto(personModel));
    }

    @ApiOperation(value = "This method is used to update a person.")
    @PatchMapping("/update/{personId}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@RequestBody @Valid PersonUpdateDTO updateDTO, @PathVariable String personId) {
        PersonModel person = this.personService.updatePerson(personId, updateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(PersonResponseDTO.convertToDto(person));
    }

    @ApiOperation("This method is used to list person by id")
    @GetMapping("/list-personId/{personId}")
    public ResponseEntity<PersonResponseDTO> listPersonById(@PathVariable String personId) {
        PersonModel personModel = this.personService.listPersonById(personId);
        return ResponseEntity.status(HttpStatus.OK).body(PersonResponseDTO.convertToDto(personModel ));
    }

    @ApiOperation("This method is used to list all person.")
    @GetMapping()
    public ResponseEntity<List<PersonResponseDTO>> listAllPerson() {
        List<PersonModel> personModelsList = this.personService.listAllPerson();
        List<PersonResponseDTO> clientCardListResponse = new ArrayList<>();

        for (PersonModel personCardModel : personModelsList) {
            clientCardListResponse.add(PersonResponseDTO.convertToDto(personCardModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(clientCardListResponse);
    }
}