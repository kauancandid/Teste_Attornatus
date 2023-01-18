package Backend_Attornatus.Teste_Attornatus.repository;


import Backend_Attornatus.Teste_Attornatus.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonModel, UUID> {

    Optional<PersonModel> findById(UUID personId);



}
