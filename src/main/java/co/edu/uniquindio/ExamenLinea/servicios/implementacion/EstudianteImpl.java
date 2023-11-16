package co.edu.uniquindio.ExamenLinea.servicios.implementacion;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.NotificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.VerExamenDTO;
import co.edu.uniquindio.ExamenLinea.modelo.entidades.*;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoExamen;
import co.edu.uniquindio.ExamenLinea.modelo.enums.TipoRespuesta;
import co.edu.uniquindio.ExamenLinea.repositorio.*;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.EstudianteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
@Transactional
public class EstudianteImpl implements EstudianteServicio {

    private final NotificacionRepo notificacionRepo;
    private final EstudianteRepo estudianteRepo;
    private final CalificacionRepo calificacionRepo;
    private final RespuestaRepo respuestaRepo;
    private final PreguntaRepo preguntaRepo;

    @Override
    public List<VerExamenDTO> verListaExamenesPendiente(int idEstudiante) throws Exception {
        Optional<Estudiante> estudiante = estudianteRepo.findById(idEstudiante);
        List<VerExamenDTO> examenesPendientes = new ArrayList<>();

        if( estudiante.isEmpty() ){
            throw new Exception("No existe un estudiante con el código "+idEstudiante);

        }
        for(Examen examen : estudiante.get().getExamenes()){
            if(examen.getEstadoExamen().equals(EstadoExamen.PENDIENTE)){
                examenesPendientes.add(new VerExamenDTO(examen.getNombre(),examen.getDescripcion(),
                        examen.getCategoria(),examen.getCantidadPreguntasBanco(),examen.getCantidadPreguntasEstudiante(),
                        examen.getTiempoLimite(),examen.getDiaEvaluacion().getId()));
            }
        }

        return examenesPendientes;
    }

    @Override
    public List<VerExamenDTO> verListaExamenesResueltos(int idEstudiante) throws Exception {
        Optional<Estudiante> estudiante = estudianteRepo.findById(idEstudiante);
        List<VerExamenDTO> examenesCompletados = new ArrayList<>();

        if( estudiante.isEmpty() ){
            throw new Exception("No existe un estudiante con el código "+idEstudiante);

        }
        for(Examen examen : estudiante.get().getExamenes()){
            if(examen.getEstadoExamen().equals(EstadoExamen.COMPLETADO)){
                examenesCompletados.add(new VerExamenDTO(examen.getNombre(),examen.getDescripcion(),
                        examen.getCategoria(),examen.getCantidadPreguntasBanco(),examen.getCantidadPreguntasEstudiante(),
                        examen.getTiempoLimite(),examen.getDiaEvaluacion().getId()));
            }
        }

        return examenesCompletados;
    }

    @Override
    public List<NotificacionDTO> verNotificaciones(int idEstudiante) throws Exception {
        List<Notificacion> notificaciones = notificacionRepo.findAll();
        List<NotificacionDTO> listaNotificacion = new ArrayList<>();

        for(Notificacion notificacion : notificaciones){
            if(notificacion.getEstudiante().getId() == idEstudiante){
                listaNotificacion.add(new NotificacionDTO(notificacion.getNotificacion(),notificacion.getId()));
            }
        }
        return listaNotificacion;
    }

    @Override
    public List<CalificacionDTO> verNotas(List<Integer> listaIDCalificacion) throws Exception {
        List<Calificacion> calificaciones = calificacionRepo.findAll();
        List<CalificacionDTO> listaCalificacion = new ArrayList<>();

        for(Calificacion calificacion : calificaciones){
            for(int idCalificacion : listaIDCalificacion){
                if(calificacion.getId() == idCalificacion){
                    listaCalificacion.add(new CalificacionDTO(calificacion.getExamen().getNombre(),
                            calificacion.getExamen().getDiaEvaluacion().getFecha(),calificacion.getNota()));
                }
            }
        }

        return listaCalificacion;
    }

    @Override
    public List<PreguntaDTO> resolverExamen(int idExamen) throws Exception {
        List<Pregunta> preguntas = preguntaRepo.findAll();
        List<PreguntaDTO> listaPreguntas = new ArrayList<>();

        for(Pregunta pregunta : preguntas){
            for(Examen examenPregunta : pregunta.getExamen()){
                if(examenPregunta.getId() == idExamen){
                    listaPreguntas.add(new PreguntaDTO(pregunta.getId(),pregunta.getPorcentaje(),pregunta.getTiempo(),
                            pregunta.getPregunta(),pregunta.getTipoPregunta()));
                }
            }
        }
        return listaPreguntas;
    }

    @Override
    public void contestarPregunta(List<PreguntaDTO> preguntas) throws Exception {
        for (PreguntaDTO pregunta : preguntas) {
            Optional<Pregunta> preguntaActual = preguntaRepo.findById(pregunta.idPregunta());
            Respuesta respuesta = new Respuesta();

            String respuestaConsola = consolaString(pregunta.pregunta());

            respuesta.setRespuesta(respuestaConsola);
            respuesta.setTipoRespuesta(TipoRespuesta.valueOf(pregunta.tipoPregunta()));
            respuesta.setEstado(EstadoEntidad.ACTIVO);
            respuesta.setPregunta(preguntaActual.get());

            respuestaRepo.save(respuesta);
        }
    }

    public String consolaString(String frase){
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar un mensaje pidiendo al usuario que ingrese un String
        System.out.print(frase);

        // Leer el String ingresado por el usuario
        String inputString = scanner.nextLine();

        // Cerrar el objeto Scanner para evitar pérdida de recursos
        scanner.close();

        return inputString;
    }

}
