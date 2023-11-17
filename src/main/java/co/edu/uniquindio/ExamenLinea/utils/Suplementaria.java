package co.edu.uniquindio.ExamenLinea.utils;

import co.edu.uniquindio.ExamenLinea.DTO.administrador.*;
import co.edu.uniquindio.ExamenLinea.repositorio.*;
import co.edu.uniquindio.ExamenLinea.servicios.implementacion.AdministradorImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Suplementaria {
    ProfesorRepo profesorRepo;
    EstudianteRepo estudianteRepo;
    GrupoRepo grupoRepo;
    PlanEstudioRepo planEstudioRepo;
    HorarioRepo horarioRepo;
    AdministradorImpl administrador = new AdministradorImpl(profesorRepo,estudianteRepo,grupoRepo,planEstudioRepo,horarioRepo);

    public void administradorOpciones() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear un Profesor");
        System.out.println("2. Buscar un Profesor por Id");
        System.out.println("3. Modificar un Profesor");
        System.out.println("4. Eliminar un Profesor");
        System.out.println("5. Crear un Estudiante");
        System.out.println("6. Buscar un Estudiante por Id");
        System.out.println("7. Modificar un Estudiante");
        System.out.println("8. Eliminar un Estudiante");
        System.out.println("9. Crear un Grupo");
        System.out.println("10. Buscar un Grupo por Id");
        System.out.println("11. Modificar un Grupo");
        System.out.println("12. Eliminar un Grupo");
        System.out.println("13. Añadir un Estudiante al Grupo");
        System.out.println("14. Eliminar un Estudiante del Grupo");
        System.out.println("15. Crear un Plan de Estudio");
        System.out.println("16. Crear un Horario");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Digite el nombre del profesor:");
                String nombreProfesor = scanner.next();

                System.out.println("Digite el nombre del profesor:");
                String apellidoProfesor = scanner.next();

                boolean respuesta = administrador.crearProfesor(new ProfesorDTO(nombreProfesor, apellidoProfesor));

                if (respuesta) {
                    System.out.println("Se ha creado el profesor correctamente");
                } else {
                    System.out.println("No se ha podido crear el profesor");
                }
            }
            case 2 -> {
                System.out.println("Digite el id del profesor: ");
                int idProfesor = scanner.nextInt();

                ProfesorDTO profesorDTO = administrador.buscarProfesorId(idProfesor);

                System.out.println("Se ha encontrado al profesor: "+profesorDTO.nombre()+" "+profesorDTO.apellido());
            }
            case 3 ->{
                System.out.println("Digite el id del profesor:");
                int idProfesor = scanner.nextInt();

                System.out.println("Digite el nombre del profesor:");
                String nombreProfesor = scanner.next();

                System.out.println("Digite el nombre del profesor:");
                String apellidoProfesor = scanner.next();

                boolean respuesta = administrador.modificarProfesorId(new ProfesorDetalleDTO(nombreProfesor,apellidoProfesor,idProfesor));

                if (respuesta) {
                System.out.println("Se ha modificado el profesor correctamente");
                } else {
                    System.out.println("No se ha podido modificar el profesor");
                }
            }
            case 4 ->{
                System.out.println("Digite el id del profesor: ");
                int idProfesor = scanner.nextInt();

                boolean respuesta = administrador.eliminarProfesor(idProfesor);

                if (respuesta) {
                    System.out.println("Se ha eliminado el profesor correctamente");
                } else {
                    System.out.println("No se ha podido eliminar el profesor");
                }
            }
            case 5 ->{
                System.out.println("Digite el nombre del estudiante:");
                String nombreEstudiante = scanner.next();

                System.out.println("Digite el nombre del estudiante:");
                String apellidoEstudiante = scanner.next();

                boolean respuesta = administrador.crearEstudiante(new EstudianteDTO(nombreEstudiante,apellidoEstudiante));

                if (respuesta) {
                    System.out.println("Se ha creado el estudiante correctamente");
                } else {
                    System.out.println("No se ha podido crear el estudiante");
                }
            }
            case 6 ->{
                System.out.println("Digite el id del estudiante: ");
                int idEstudiante = scanner.nextInt();

                EstudianteDTO estudianteDTO = administrador.buscarEstudianteId(idEstudiante);

                System.out.println("Se ha encontrado al estudiante: "+estudianteDTO.nombre()+" "+estudianteDTO.apellido());
            }
            case 7 ->{
                System.out.println("Digite el id del estudiante:");
                int idEstudiante = scanner.nextInt();

                System.out.println("Digite el nombre del estudiante:");
                String nombreEstudiante = scanner.next();

                System.out.println("Digite el nombre del estudiante:");
                String apellidoEstudiante = scanner.next();

                boolean respuesta = administrador.modificarEstudianteId(new EstudianteDetalleDTO(idEstudiante,nombreEstudiante,apellidoEstudiante));

                if (respuesta) {
                    System.out.println("Se ha modificado el estudiante correctamente");
                } else {
                    System.out.println("No se ha podido modificar el estudiante");
                }
            }
            case 8 ->{
                System.out.println("Digite el id del estudiante: ");
                int idEstudiante = scanner.nextInt();

                boolean respuesta = administrador.eliminarEstudiante(idEstudiante);

                if (respuesta) {
                    System.out.println("Se ha eliminado el estudiante correctamente");
                } else {
                    System.out.println("No se ha podido eliminar el estudiante");
                }
            }
            case 9 ->{
                System.out.println("Digite el nombre del grupo:");
                String nombreGrupo = scanner.next();

                System.out.println("Digite el id del plan de estudio:");
                int idPlanEstudio = scanner.nextInt();

                System.out.println("Digite el id del horario:");
                int idHorario = scanner.nextInt();

                System.out.println("Digite el id del profesor:");
                int idProfesor = scanner.nextInt();

                boolean respuesta = administrador.crearGrupo(new GrupoDTO(nombreGrupo,idPlanEstudio,idHorario,idProfesor));

                if (respuesta) {
                    System.out.println("Se ha creado el grupo correctamente");
                } else {
                    System.out.println("No se ha podido crear el grupo");
                }
            }
            case 10 ->{
                System.out.println("Digite el id del grupo: ");
                int idGrupo = scanner.nextInt();

                GrupoDTO grupoDTO = administrador.buscarGrupoId(idGrupo);

                System.out.println("Se ha encontrado al grupo: "+grupoDTO.nombre());

            }
            case 11 ->{
                System.out.println("Digite el id del grupo:");
                int idGrupo = scanner.nextInt();

                System.out.println("Digite el nombre del grupo: ");
                String nombreGrupo = scanner.next();

                System.out.println("Digite el id del plan de estudio:");
                int idPlanEstudio = scanner.nextInt();

                System.out.println("Digite el id del horario:");
                int idHorario = scanner.nextInt();

                System.out.println("Digite el id del profesor:");
                int idProfesor = scanner.nextInt();

                boolean respuesta = administrador.modificarGrupoId(new GrupoDetalleDTO(idGrupo,nombreGrupo,idPlanEstudio,idHorario,idProfesor));

                if (respuesta) {
                    System.out.println("Se ha modificado el grupo correctamente");
                } else {
                    System.out.println("No se ha podido modificar el grupo");
                }
            }
            case 12 ->{
                System.out.println("Digite el id del grupo: ");
                int idGrupo = scanner.nextInt();

                boolean respuesta = administrador.eliminarGrupo(idGrupo);

                if (respuesta) {
                    System.out.println("Se ha eliminado el grupo correctamente");
                } else {
                    System.out.println("No se ha podido eliminar el grupo");
                }
            }
            case 13 ->{
                System.out.println("Digite el id del grupo:");
                int idGrupo = scanner.nextInt();

                System.out.println("Digite el id del estudiante: ");
                int idEstudiante = scanner.nextInt();

                boolean respuesta = administrador.aniadirEstudianteGrupo(new EstudianteGrupoDTO(idGrupo,idEstudiante));

                if (respuesta) {
                    System.out.println("Se ha añadido el estudiante al grupo correctamente");
                } else {
                    System.out.println("No se ha podido añadir el estudiante al grupo");
                }
            }
            case 14 ->{
                System.out.println("Digite el id del grupo:");
                int idGrupo = scanner.nextInt();

                System.out.println("Digite el id del estudiante: ");
                int idEstudiante = scanner.nextInt();

                boolean respuesta = administrador.eliminarEstudianteGrupo(new EstudianteGrupoDTO(idGrupo,idEstudiante));

                if (respuesta) {
                    System.out.println("Se ha eliminado el estudiante del grupo correctamente");
                } else {
                    System.out.println("No se ha podido eliminar el estudiante frl grupo");
                }
            }
            case 15 ->{
                System.out.println("Digite el numero de unidades:");
                int unidades = scanner.nextInt();

                System.out.println("Digite el contenido:");
                String contenido = scanner.next();

                boolean respuesta = administrador.crearPlanEstudio(new PlanEstudioDTO(unidades,contenido));

                if (respuesta) {
                    System.out.println("Se ha creado el plan de estudio correctamente");
                } else {
                    System.out.println("No se ha podido crear el plan de estudio");
                }
            }
            case 16 ->{
                System.out.println("Digite el año de la clase:");
                int anio = scanner.nextInt();

                System.out.println("Digite el mes de la clase(numero):");
                int mes = scanner.nextInt();

                System.out.println("Digite el dia de la clase:");
                int dia = scanner.nextInt();

                System.out.println("Digite la hora de la clase con el formato HH:mm(24 horas):");
                String hora = scanner.next();

                System.out.println("Digite el lugar de la clase:");
                String lugar = scanner.next();

                LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, 0, 0);;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                // Parsea la cadena a un objeto LocalTime
                LocalTime horaAux = LocalTime.parse(hora, formatter);

                boolean respuesta = administrador.crearHorario(new HorarioDTO(fecha,horaAux,lugar));

                if (respuesta) {
                    System.out.println("Se ha creado el horario correctamente");
                } else {
                    System.out.println("No se ha podido crear el horario");
                }
            }
            case 17 ->{

            }
            default -> System.out.println("Opción no válida.");
        }
    }

    public void estudianteOpciones() {
    }

    public void profesorOpciones() {
    }

}
