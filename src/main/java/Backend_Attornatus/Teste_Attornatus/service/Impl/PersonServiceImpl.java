package Backend_Attornatus.Teste_Attornatus.service.Impl;

import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonRequestDTO;
import Backend_Attornatus.Teste_Attornatus.dto.personDto.PersonUpdateDTO;
import Backend_Attornatus.Teste_Attornatus.model.AddressModel;
import Backend_Attornatus.Teste_Attornatus.model.PersonModel;
import Backend_Attornatus.Teste_Attornatus.repository.AddressRepository;
import Backend_Attornatus.Teste_Attornatus.repository.PersonRepository;
import Backend_Attornatus.Teste_Attornatus.service.PersonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressServiceImpl addressService;
    private final AddressRepository addressRepository;

    public PersonServiceImpl(PersonRepository personRepository, AddressServiceImpl addressService, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressService = addressService;
        this.addressRepository = addressRepository;
    }


    @Transactional
    public PersonModel savePerson(PersonRequestDTO userRequest) {

        var personModel = new PersonModel();
        personModel.setName(userRequest.getName());
        personModel.setBirthDate(userRequest.getBirthDate());

        var personSave = this.personRepository.save(personModel);

        var address = new AddressModel();
        address.setPerson(personSave);
        address.setNumber(userRequest.getAddress().getNumber());
        address.setCity(userRequest.getAddress().getCity());
        address.setPublicPlace(userRequest.getAddress().getPublicPlace());
        address.setPostalCode(userRequest.getAddress().getPostalCode());

        addressService.saveAddress(address, String.valueOf(personSave.getId()));
        return personSave;
    }

    @Override
    public PersonModel updatePerson(String personId, PersonUpdateDTO updatePerson) {
        Optional<PersonModel> personOptional = this.personRepository.findById(UUID.fromString(personId));
        if(personOptional.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrado!");
        }

        PersonModel person = personOptional.get();
        person.setName(updatePerson.getName());
        person.setBirthDate(updatePerson.getBirthDate());

        return this.personRepository.save(person);
    }

    @Override
    public PersonModel listPersonById(String personId){
        Optional<PersonModel> personModel = this.personRepository.findById(UUID.fromString(personId));
        if(personModel.isEmpty()){
            throw  new RuntimeException("Pessoa não encontrada");
        }
        return personModel.get();
    }

    @Override
    public List<PersonModel> listAllPerson() {
        return personRepository.findAll();

    }

}
