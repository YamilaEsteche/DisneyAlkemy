
package disneyAlkemy.disney.entity;




import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name ="personajes")
@Setter
@Getter


public class PersonajeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String nombre;
    private Integer edad;
    private Double  peso;
    private String historia;

    @ManyToMany (mappedBy = "personajes", cascade= CascadeType.ALL)
    private Set<PeliculaEntity> peliculas = new HashSet<>(); //la relacion esta en pelicula, suele ser mejor usar set q list
    //cuando creo un personaje no le puede pasar la lista para que cree una peli
}
