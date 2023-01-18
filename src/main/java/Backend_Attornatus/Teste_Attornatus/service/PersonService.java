package Backend_Attornatus.Teste_Attornatus.service;



import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonRequestDTO;
import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonUpdateDTO;
import Backend_Attornatus.Teste_Attornatus.model.PersonModel;

import java.util.List;

public interface PersonService {

    PersonModel savePerson(PersonRequestDTO address);

    PersonModel updatePerson(String personId, PersonUpdateDTO updatePerson);

    PersonModel listPersonById(String personId);

    List<PersonModel> listAllPerson();


}
