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
        int idConfiguracion = 1;

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
    }

    public void estadisticaExamen() throws Exception{

    }

    public void estadisticaPregunta() throws Exception{

    }

    public void verNotasEstudiante() throws Exception{

    }

    public void crearPregunta() throws Exception{

    }

    public void crearTema() throws Exception{

    }

    public void crearBancoPreguntas() throws Exception{

    }

    public void enviarExamenEstudiantes() throws Exception{

    }



}
