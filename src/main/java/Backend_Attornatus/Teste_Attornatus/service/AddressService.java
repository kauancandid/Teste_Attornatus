package Backend_Attornatus.Teste_Attornatus.service;


import Backend_Attornatus.Teste_Attornatus.model.AddressModel;

import java.util.List;

public interface AddressService {

    AddressModel saveAddress(AddressModel address, String personId);

    List<AddressModel> listAllAddressByPersonId(String addressId);

    AddressModel listAddressMainByPersonId(String personId);

}