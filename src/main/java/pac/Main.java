package pac;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main extends NullPointerException {
    public static void main(String[] args) {
        // Creamos los datos para la conexión con la BBDD
        System.out.println("Iniciando configuración hibernate....");
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        System.out.println("CONFIGURACION REALIZADA");
        // Insertar datos en la BD
        Transaction tx = session.beginTransaction();
        //Inserción de datos para la BD Modulo
        Modulo mod1 = new Modulo();
        mod1.Modulo("Programacion B ","M03B");
        Modulo mod2 = new Modulo();
        mod2.Modulo("Acceso a Datos ","M06");
        Modulo mod3 = new Modulo();
        mod3.Modulo("Desarrollo de aplicaciones moviles","M08");
        Modulo mod4 = new Modulo();
        mod4.Modulo("Servicios y procesos ","M09");
        System.out.println(mod1.toString());
        System.out.println(mod2.toString());
        System.out.println(mod3.toString());
        System.out.println(mod4.toString());
        //Salvamos los datos
        session.save(mod1);
        session.save(mod2);
        session.save(mod3);
        session.save(mod4);
        System.out.println();
        //Inserción de datos para la BD Profesor
        Profesor prof = new Profesor();
        prof.crearProfesor("Alvaro", "Hombre");
        System.out.println(prof.toString());
        session.save(prof);
        //Inserción de datos para la BD Alumno
        //Creamos el primer objeto de la clase Alumno
        Alumno alumno1 = new Alumno();
        alumno1.Alumno("Juan","Espaniola",26,"Hombre");
        // Insertamos los módulos a los que pertenece este alumno
        alumno1.getModulos().add(mod1);
        alumno1.getModulos().add(mod2);
        alumno1.getModulos().add(mod3);
        alumno1.getModulos().add(mod4);
        System.out.println(alumno1.toString());
        session.save(alumno1); // Salvamos la session del primer alumno
        //Creamos el segundo objeto de la clase Alumno
        Alumno alumno2 = new Alumno();
        alumno2.Alumno("Pedro","Andorrana",21,"Hombre");
        // Insertamos los módulos a los que pertenece este alumno
        alumno2.getModulos().add(mod1);
        alumno2.getModulos().add(mod2);
        alumno2.getModulos().add(mod4);
        System.out.println(alumno2.toString());
        session.save(alumno2);// Salvamos la session del segundo alumno
        //Creamos el tercer objeto de la clase Alumno
        Alumno alumno3 = new Alumno();
        alumno3.Alumno("Marta","Espaniola",19,"Mujer");
        // Insertamos los módulos a los que pertenece este alumno
        alumno3.getModulos().add(mod3);
        alumno3.getModulos().add(mod4);
        System.out.println(alumno3.toString());
        session.save(alumno3);// Salvamos la session del tercer alumno
        //Creamos el cuarto objeto de la clase Alumno
        Alumno alumno4 = new Alumno();
        alumno4.Alumno("Carla","Francesa",35,"Mujer");
        // Insertamos los módulos a los que pertenece este alumno
        alumno4.getModulos().add(mod2);
        alumno4.getModulos().add(mod3);
        alumno4.getModulos().add(mod4);
        System.out.println(alumno4.toString());
        session.save(alumno4);// Salvamos la session del cuarto alumno

        tx.commit();//Confirmamos los datos
        session.close();// Cerramos la session
        sessionFactory.close();// Cerramos la conexión con el conector
    }



}
