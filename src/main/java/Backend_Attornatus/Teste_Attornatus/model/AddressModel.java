package Backend_Attornatus.Teste_Attornatus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false)
    private String publicPlace;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String city;

    //Para mostrar qual seria o endereço principal da pessoa
    @Column(nullable = false)
    private boolean main = true;

    @ManyToOne
    @JoinColumn(nullable = false, name = "person_id", referencedColumnName = "id")
    private PersonModel person;



}
