package pac;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Creación Entidad y nombre de la tabla
@Entity
@Table(name = "alumnos")

public class Alumno implements Serializable {

// Creamos el constructor de la clase Alumno, incluido con la función Set para el almacenamiento de datos
    public Alumno(Long id, String nombre, String nacionalidad, int edad, String sexo, Set<Modulo> modulos) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sexo = sexo;
        this.modulos = modulos;

    }
// Creamos el constructor de la clase, sin el Set para introducir los datos necesarios.
    public void Alumno(String nombre, String nacionalidad, int edad, String sexo) {

        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sexo = sexo;
        this.modulos = new HashSet<Modulo>();
    }

    public Alumno() {

    }
// Getters y Setters de Alumno
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {

        this.sexo = sexo;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {

        this.modulos = modulos;
    }

// Función para mostrar datos por pantalla
    @Override
    public String toString() {
        return "Insert into alumno, nombre: " +
                nombre + ", nacionalidad: " +
                nacionalidad + ", edad: " + edad +
                ", sexo: " + sexo +
                ", modulos: " + modulos.size();
    }

// Creamos el autoincrement, de la clase, para que genere los valores automáticos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Long id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    // Aqui le decimos la relación que tendrá con la clase Modulos, de Muchos a Muchos
    @ManyToMany
    private Set<Modulo> modulos = new HashSet<>();



}


