package Backend_Attornatus.Teste_Attornatus.repository;


import Backend_Attornatus.Teste_Attornatus.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface AddressRepository extends JpaRepository<AddressModel, UUID> {

    Optional<AddressModel> findById(UUID uuid);

    Optional<AddressModel> findByPersonIdAndMain(UUID personId);

    List<AddressModel> findByPersonId(UUID personId);



}