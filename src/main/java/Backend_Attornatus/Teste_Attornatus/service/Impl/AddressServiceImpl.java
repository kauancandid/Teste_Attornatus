package Backend_Attornatus.Teste_Attornatus.service.Impl;


import Backend_Attornatus.Teste_Attornatus.model.AddressModel;
import Backend_Attornatus.Teste_Attornatus.model.PersonModel;
import Backend_Attornatus.Teste_Attornatus.repository.AddressRepository;
import Backend_Attornatus.Teste_Attornatus.repository.PersonRepository;
import Backend_Attornatus.Teste_Attornatus.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }


    @Override
    public AddressModel saveAddress(AddressModel addressModel, String personId) {

        Optional<PersonModel> person = this.personRepository.findById(UUID.fromString(personId));
        if (person.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrada!");
        }

        Optional<AddressModel> address = this.addressRepository.findByPersonIdAndMain(UUID.fromString(personId));
        AddressModel adressModel = new AddressModel();
        if (address.isPresent()) {
            adressModel.setMain(false);
        }

        var addressSave = addressRepository.save(adressModel);
        var personSave = person.get();
        personSave.getAddresses().add(addressSave);
        personRepository.save(personSave);
        return addressSave;
    }


    @Override
    public List<AddressModel> listAllAddressByPersonId(String personId) {
        Optional<PersonModel> personModel = this.personRepository.findById(UUID.fromString(personId));
        if(personModel.isEmpty()){
            throw  new RuntimeException("Pessoa não encontrada");
        }

        var person = personModel.get();
        return addressRepository.findByPersonId(person.getId());

    }

    @Override
    public AddressModel listAddressMainByPersonId(String personId){
        Optional<AddressModel> address = this.addressRepository.findByPersonIdAndMain(UUID.fromString(personId));
        if(address.isEmpty()){
            new RuntimeException("Endereço principal não encontrado");
        }
        return address.get();
    }


}
