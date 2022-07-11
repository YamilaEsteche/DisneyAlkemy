
package disneyAlkemy.disney.entity;

import lombok.Getter; //con esto ahorro lineas de codigo
import lombok.Setter;
import javax.persistence.*;




@Entity
@Table(name ="generos") //como se va a llamar mi tabla en mysql
@Setter
@Getter
public class GeneroEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String imagen;

    
}
