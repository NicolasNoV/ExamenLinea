package co.edu.uniquindio.ExamenLinea.test;

import co.edu.uniquindio.ExamenLinea.DTO.administrador.*;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    public void crearProfesorTest() throws Exception{
        String nombreProfesor = "Carlos";

        String apellidoProfesor = "Bosque";

        boolean respuesta = administradorServicio.crearProfesor(new ProfesorDTO(nombreProfesor, apellidoProfesor));

        Assertions.assertTrue(respuesta);
    }

    public void buscarProfesorId() throws Exception{
        int idProfesor = 1;

        ProfesorDTO profesorDTO = administradorServicio.buscarProfesorId(idProfesor);
        Assertions.assertNotEquals(null,profesorDTO);
    }

    public void modificarProfesorId() throws Exception{
        int idProfesor = 1;

        String nombreProfesor = "Juan";

        String apellidoProfesor = "Vargas";

        boolean respuesta = administradorServicio.modificarProfesorId(new ProfesorDetalleDTO(nombreProfesor,apellidoProfesor,idProfesor));

        Assertions.assertTrue(respuesta);
    }

    public void eliminarProfesor() throws Exception{
        int idProfesor = 1;

        boolean respuesta = administradorServicio.eliminarProfesor(idProfesor);

        Assertions.assertTrue(respuesta);
    }

    public void crearEstudiante() throws Exception{
        String nombreEstudiante = "Marta";

        String apellidoEstudiante = "Herrera";

        boolean respuesta = administradorServicio.crearEstudiante(new EstudianteDTO(nombreEstudiante,apellidoEstudiante));

        Assertions.assertTrue(respuesta);
    }

    public void buscarEstudianteId() throws Exception{
        int idEstudiante = 1;

        EstudianteDTO estudianteDTO = administradorServicio.buscarEstudianteId(idEstudiante);

        Assertions.assertNotEquals(null,estudianteDTO);
    }

    public void modificarEstudianteId() throws Exception{
        int idEstudiante = 1;

        String nombreEstudiante = "Luz";

        String apellidoEstudiante = "Herrera";

        boolean respuesta = administradorServicio.modificarEstudianteId(new EstudianteDetalleDTO(idEstudiante,nombreEstudiante,apellidoEstudiante));

        Assertions.assertTrue(respuesta);
    }

    public void eliminarEstudiante() throws Exception{
        int idEstudiante = 1;

        boolean respuesta = administradorServicio.eliminarEstudiante(idEstudiante);

        Assertions.assertTrue(respuesta);
    }

    public void crearGrupo() throws Exception{
        String nombreGrupo = "Grupo A";

        int idPlanEstudio = 1;

        int idHorario = 1;

        int idProfesor = 1;

        boolean respuesta = administradorServicio.crearGrupo(new GrupoDTO(nombreGrupo,idPlanEstudio,idHorario,idProfesor));

        Assertions.assertTrue(respuesta);
    }

    public void buscarGrupoId() throws Exception{
        int idGrupo = 1;

        GrupoDTO grupoDTO = administradorServicio.buscarGrupoId(idGrupo);

        Assertions.assertNotEquals(null,grupoDTO);
    }

    public void modificarGrupoId() throws Exception{
        int idGrupo = 1;

        String nombreGrupo = "Grupo B";

        int idPlanEstudio = 1;

        int idHorario = 1;

        int idProfesor = 1;

        boolean respuesta = administradorServicio.modificarGrupoId(new GrupoDetalleDTO(idGrupo,nombreGrupo,idPlanEstudio,idHorario,idProfesor));

        Assertions.assertTrue(respuesta);
    }

    public void eliminarGrupo() throws Exception{
        int idGrupo = 1;

        boolean respuesta = administradorServicio.eliminarGrupo(idGrupo);

        Assertions.assertTrue(respuesta);
    }

    public void aniadirEstudianteGrupo() throws Exception{
        int idGrupo = 1;

        int idEstudiante = 1;

        boolean respuesta = administradorServicio.aniadirEstudianteGrupo(new EstudianteGrupoDTO(idGrupo,idEstudiante));

        Assertions.assertTrue(respuesta);
    }

    public void eliminarEstudianteGrupo() throws Exception{
        int idGrupo = 1;

        int idEstudiante = 1;

        boolean respuesta = administradorServicio.eliminarEstudianteGrupo(new EstudianteGrupoDTO(idGrupo,idEstudiante));

        Assertions.assertTrue(respuesta);
    }

    public void crearPlanEstudio() throws Exception{
        int unidades = 4;

        String contenido = "Contenido muy interesante";

        boolean respuesta = administradorServicio.crearPlanEstudio(new PlanEstudioDTO(unidades,contenido));

        Assertions.assertTrue(respuesta);
    }

    public void crearHorario() throws Exception{
        int anio = 2023;

        int mes = 11;

        int dia = 16;

        String hora = "10:26";

        String lugar = "Universidad";

        LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, 0, 0);;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parsea la cadena a un objeto LocalTime
        LocalTime horaAux = LocalTime.parse(hora, formatter);

        boolean respuesta = administradorServicio.crearHorario(new HorarioDTO(fecha,horaAux,lugar));

        Assertions.assertTrue(respuesta);
    }
}
