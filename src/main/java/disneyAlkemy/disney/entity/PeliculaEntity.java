
package disneyAlkemy.disney.entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="pelicula")
@Setter
@Getter

public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String titulo;
    private Integer calificacion; // va a llevar el column si el atributo se llama distinto de la columna
    
    @Column(name = "fecha_creacion") 
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    
    
    
    //1 Pelicula tiene SOLO un genero, muchas peliculas van a estar en un genero, cada pelicula no puede estar en mas de un genero
   
    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL) //eager inicializacion temprana caundo pida un dato de tipo pelicula me va a venir con su genero
    //cascadeAll para que se aplique a todo cuando hago algo
    @JoinColumn(name = "generoId", insertable = false, updatable = false )
    private GeneroEntity genero; //me joineo con la tabla

    @Column(name="generoId", nullable=false)
    private long generoId; //le envio un id de genero, cuando quiero crear una peli aca se va enviar un id de genero?¿
    
    
    
    
   // 1 Pelicula tiene muchos personajes  y muchos personajes tienen 1 pelicula,pelicula engloba personaje
    @ManyToMany( cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE 
    })
    
    
    @JoinTable( name = "personajes_peliculas",//como se llama la tabla intermedia
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "personajes_peliculas"))

    private Set <PersonajeEntity> personajes = new HashSet<>();
    

}
