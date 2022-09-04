package pac;

import javax.persistence.*;
import java.io.Serializable;
// Creamos la entidad y el nombre de la tabla
@Entity(name="profesores")


public class Profesor implements Serializable{

    public Profesor(){}

    public void crearProfesor(String nombre, String sexo){ // Constructor de la clase, sin id, se genera auto en la tabla
        this.nombre=nombre;
        this.sexo=sexo;
    }

    public Profesor(Long id, String nombre, String sexo) { // Constructor de la clase
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
    }
// Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    // Función  para mostrar datos por pantalla
    @Override
    public String toString() {
        return "Insert into profesor, nombre: " +
                nombre +
                ", sexo: " + sexo;
    }
    // Asignamos la id de la tabla y asignamos el nobre de la columna
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesor")
    private Long id;
    private String nombre;
    private String sexo;
}
