package pac;

import javax.persistence.*;
import java.io.Serializable;
// Creamos la entidad y le damos el nombre a la tabla
@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {

    public Modulo() {

    }
    public void Modulo(String nombre, String codigo) { // Constructor de la clase sin la id, ya que se genera auto
        this.nombre = nombre;
        this.codigo=codigo;
    }

    public Modulo(Long id, String nombre, String codigo) { // Constructor de la clase completa
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }
        // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Funcion para imprimir datos por consola
    @Override
    public String toString() {
        return "Insert into modulo, nombre: " +
                nombre +
                ", codigo: " + codigo;
    }
    // Creamos la id de la tabla y el generamos el nombre de la columna
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo")
    private Long id;
    private String nombre;
    private String codigo;


}
