package co.edu.uniquindio.ExamenLinea.test;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.administrador.ProfesorDTO;
import co.edu.uniquindio.ExamenLinea.DTO.profesor.*;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoExamen;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.ProfesorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProfesorServicioTest {

    @Autowired
    private ProfesorServicio profesorServicio;
    @Test
    public void crearExamen() throws Exception{
        String nombre = "Examen Biologia";
        String descripcion = "Un examen de una pregunta sobre biologia";
        String categoria = "Biologia";
        EstadoExamen estadoExamen = EstadoExamen.PENDIENTE;
        int cantidadPreguntasBanco = 1;
        int cantidadPreguntasEstudiante = 1;
        LocalDateTime tiempoLimite = LocalDateTime.now();
        int idDiaEvaluacion = 1;

        boolean respuesta = profesorServicio.crearExamen(new ExamenDTO(nombre,descripcion,categoria,estadoExamen,cantidadPreguntasBanco,
                cantidadPreguntasEstudiante,tiempoLimite,idDiaEvaluacion));

        Assertions.assertTrue(respuesta);
    }

    public void agregarPreguntasExamen() throws Exception{
        int idPregunta = 1;
        int idExamen = 1;

        boolean respuesta = profesorServicio.agregarPreguntasExamen(new PreguntaExamenDTO(idPregunta,idExamen));

        Assertions.assertTrue(respuesta);
    }

    public void configurarExamen() throws Exception{
        double porcentaje = 100;
        double umbral = 1;
        LocalDateTime hora = LocalDateTime.now();
        LocalDateTime fecha = LocalDateTime.now();
        int numeroPreguntas = 1;
        LocalDateTime tiempo = LocalDateTime.now();
        int idExamen = 1;

        boolean respuesta = profesorServicio.configurarExamen(new ConfiguracionDTO(porcentaje,umbral,hora,fecha,
                        numeroPreguntas,tiempo,idExamen));

        Assertions.assertTrue(respuesta);
    }

    public void estadisticaExamen() throws Exception{
        int idEstadisticaExamen = 1;

        EstadisticaExamenDTO estadisticaExamen = profesorServicio.estadisticaExamen(idEstadisticaExamen);

        Assertions.assertNotEquals(null,estadisticaExamen);
    }

    public void estadisticaPregunta() throws Exception{
        int idEstadisticaPregunta = 1;

        EstadisticaPreguntaDTO estadisticaPregunta = profesorServicio.estadisticaPregunta(idEstadisticaPregunta);

        Assertions.assertNotEquals(null,estadisticaPregunta);
    }

    public void verNotasEstudiante() throws Exception{
        int idEstudiante = 1;

        List<CalificacionDTO> notasEstudiante = profesorServicio.verNotasEstudiante(idEstudiante);

        Assertions.assertEquals(0, notasEstudiante.size());
    }

    public void crearPregunta() throws Exception{
        int idPregunta = 1;
        double porcentaje = 100;
        LocalDateTime tiempo = LocalDateTime.now();
        String pregunta = "Cual es el nombre cientifico de las celulas";
        String tipoPregunta = "SELECCION_MULTIPLE_UNICA_RESPUESTA";

        boolean respuesta = profesorServicio.crearPregunta(new PreguntaDTO(idPregunta,porcentaje,tiempo,pregunta,tipoPregunta));

        Assertions.assertTrue(respuesta);
    }

    public void crearTema() throws Exception{
        String nombre = "Biologia";

        boolean respuesta = profesorServicio.crearTema(nombre);

        Assertions.assertTrue(respuesta);
    }

    public void crearBancoPreguntas() throws Exception{
        int idTema = 1;

        boolean respuesta = profesorServicio.crearBancoPreguntas(idTema);

        Assertions.assertTrue(respuesta);
    }

    public void enviarExamenEstudiantes() throws Exception{
        List<Integer> idEstudiantes = new ArrayList<>();
        idEstudiantes.add(1);
        idEstudiantes.add(2);

        int idExamen = 1;

        boolean respuesta = profesorServicio.enviarExamenEstudiantes(new EnviarExamenEstudiantesDTO(idEstudiantes,idExamen));

        Assertions.assertTrue(respuesta);
    }
}
