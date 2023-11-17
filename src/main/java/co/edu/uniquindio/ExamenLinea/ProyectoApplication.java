package co.edu.uniquindio.ExamenLinea;

import co.edu.uniquindio.ExamenLinea.repositorio.*;
import co.edu.uniquindio.ExamenLinea.servicios.implementacion.AdministradorImpl;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.ExamenLinea.utils.Suplementaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProyectoApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(ProyectoApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Metodos Administrador");
        System.out.println("2. Metodos Estudiante");
        System.out.println("3. Metodos Profesor");
        System.out.println("4. Salir del Programa");

        Suplementaria suplementaria = new Suplementaria();

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1 ->
                // Acceder a los metodos de administrador
                    suplementaria.administradorOpciones();
            case 2 ->
                // Acceder a los metodos de Estudiante
                    suplementaria.estudianteOpciones();
            case 3 ->
                // Acceder a los metodos de Profesor
                    suplementaria.profesorOpciones();
            case 4 ->
                //Salir del programa
                    System.out.println("Saliendo del programa.");
            default -> System.out.println("Opción no válida.");
        }
    }
}