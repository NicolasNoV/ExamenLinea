package co.edu.uniquindio.ExamenLinea.test;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.administrador.ProfesorDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.ContestarPreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.NotificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.VerExamenDTO;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.EstudianteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EstudianteServicioTest {

    @Autowired
    private EstudianteServicio estudianteServicio;

    public void verListaExamenesPendiente() throws Exception{
        int idEstudiante = 1;

        List<VerExamenDTO> examenesPendientes = estudianteServicio.verListaExamenesPendiente(idEstudiante);

        Assertions.assertEquals(0, examenesPendientes.size());
    }

    public void verListaExamenesResueltos() throws Exception{
        int idEstudiante = 1;

        List<VerExamenDTO> examenesResueltos = estudianteServicio.verListaExamenesResueltos(idEstudiante);

        Assertions.assertEquals(0, examenesResueltos.size());
    }

    public void verNotificaciones() throws Exception{
        int idEstudiante = 1;

        List<NotificacionDTO> notificaciones = estudianteServicio.verNotificaciones(idEstudiante);

        Assertions.assertEquals(0, notificaciones.size());
    }

    public void verNotas() throws Exception{
        List<Integer> idCalificaciones = new ArrayList<>();
        idCalificaciones.add(1);
        idCalificaciones.add(2);

        List<CalificacionDTO> notas = estudianteServicio.verNotas(idCalificaciones);

        Assertions.assertEquals(0, notas.size());
    }
    @Test
    public void resolverExamen() throws Exception{
        int idExamen = 1;

        List<PreguntaDTO> preguntas = estudianteServicio.resolverExamen(idExamen);

        Assertions.assertEquals(0, preguntas.size());

        contestarPregunta(preguntas);
    }

    public void contestarPregunta(List<PreguntaDTO> preguntas) throws Exception{
        int idExamen = 1;

        boolean respuesta = estudianteServicio.contestarPregunta(new ContestarPreguntaDTO(preguntas,idExamen));

        Assertions.assertTrue(respuesta);
    }

}