package co.edu.uniquindio.ExamenLinea.controladores;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.MensajeDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.administrador.*;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.ContestarPreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.NotificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.VerExamenDTO;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.EstudianteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/administrador")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorServicio administradorServicio;
    private final EstudianteServicio estudianteServicio;

    @PostMapping("/crear-profesor")
    public ResponseEntity<MensajeDTO<String>> crearProfesor(@Valid @RequestBody ProfesorDTO profesorDTO) throws Exception{
        administradorServicio.crearProfesor(profesorDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha creado un profesor correctamente"));
    }

    @GetMapping("/buscar-profesor/{idProfesor}")
    public ResponseEntity<MensajeDTO<ProfesorDTO>> buscarProfesorId(@PathVariable int idProfesor) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.buscarProfesorId(idProfesor)));
    }

    @PutMapping("/modificar-profesor")
     public ResponseEntity<MensajeDTO<String>> modificarProfesorId(@Valid @RequestBody ProfesorDetalleDTO profesorDetalleDTO) throws Exception{
        administradorServicio.modificarProfesorId(profesorDetalleDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha modificado un profesor correctamente"));
    }

    @DeleteMapping("/eliminar-profesor/{idProfesor}")
    public ResponseEntity<MensajeDTO<String>> eliminarProfesor(@PathVariable int idProfesor) throws Exception{
        administradorServicio.eliminarProfesor(idProfesor);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha eliminado un profesor correctamente"));
    }



    @PostMapping("/crear-estudiante")
    public ResponseEntity<MensajeDTO<String>> crearEstudiante(@Valid @RequestBody EstudianteDTO estudianteDTO) throws Exception{
        administradorServicio.crearEstudiante(estudianteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha creado un estudiante correctamente"));
    }
    @GetMapping("/buscar-estudiante/{idEstudiante}")
    public ResponseEntity<MensajeDTO<EstudianteDTO>> buscarEstudianteId(@PathVariable int idEstudiante) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.buscarEstudianteId(idEstudiante)));
    }

    @PutMapping("/modificar-estudiante")
    public ResponseEntity<MensajeDTO<String>> modificarEstudiante(@Valid @RequestBody EstudianteDetalleDTO estudianteDetalleDTO) throws Exception {
        administradorServicio.modificarEstudianteId(estudianteDetalleDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Estudiante modificado correctamente"));
    }

    @DeleteMapping("/eliminar-estudiante/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminarEstudiante(@PathVariable int id) throws Exception {
        administradorServicio.eliminarEstudiante(id);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Estudiante eliminado correctamente"));
    }

    @PostMapping("/crear-grupo")
    public ResponseEntity<MensajeDTO<String>> crearGrupo(@Valid @RequestBody GrupoDTO grupoDTO) throws Exception {
        administradorServicio.crearGrupo(grupoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Grupo creado correctamente"));
    }

    @GetMapping("/buscar-grupo/{id}")
    public ResponseEntity<GrupoDTO> buscarGrupo(@PathVariable int id) throws Exception {
        GrupoDTO grupoDTO = administradorServicio.buscarGrupoId(id);
        return ResponseEntity.ok().body(grupoDTO);
    }

    @PutMapping("/modificar-grupo")
    public ResponseEntity<MensajeDTO<String>> modificarGrupo(@Valid @RequestBody GrupoDetalleDTO grupoDetalleDTO) throws Exception {
        administradorServicio.modificarGrupoId(grupoDetalleDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Grupo modificado correctamente"));
    }

    @DeleteMapping("/eliminar-grupo/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminarGrupo(@PathVariable int id) throws Exception {
        administradorServicio.eliminarGrupo(id);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Grupo eliminado correctamente"));
    }

    @PostMapping("/aniadir-estudiante-grupo")
    public ResponseEntity<MensajeDTO<String>> aniadirEstudianteGrupo(@Valid @RequestBody EstudianteGrupoDTO estudianteGrupoDTO) throws Exception {
        administradorServicio.aniadirEstudianteGrupo(estudianteGrupoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Estudiante añadido al grupo correctamente"));
    }

    @DeleteMapping("/eliminar-estudiante-grupo")
    public ResponseEntity<MensajeDTO<String>> eliminarEstudianteGrupo(@Valid @RequestBody EstudianteGrupoDTO estudianteGrupoDTO) throws Exception {
        administradorServicio.eliminarEstudianteGrupo(estudianteGrupoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Estudiante eliminado del grupo correctamente"));
    }

    @PostMapping("/crear-plan-estudio")
    public ResponseEntity<MensajeDTO<String>> crearPlanEstudio(@Valid @RequestBody PlanEstudioDTO planEstudioDTO) throws Exception {
        administradorServicio.crearPlanEstudio(planEstudioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Plan de estudio creado correctamente"));
    }

    @PostMapping("/crear-horario")
    public ResponseEntity<MensajeDTO<String>> crearHorario(@Valid @RequestBody HorarioDTO horarioDTO) throws Exception {
        administradorServicio.crearHorario(horarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Horario creado correctamente"));
    }

    @GetMapping("/examenes-pendientes/{idEstudiante}")
    public ResponseEntity<List<VerExamenDTO>> verExamenesPendientes(@PathVariable int idEstudiante) throws Exception {
        List<VerExamenDTO> examenesPendientes = estudianteServicio.verListaExamenesPendiente(idEstudiante);
        return ResponseEntity.ok().body(examenesPendientes);
    }

    @GetMapping("/examenes-resueltos/{idEstudiante}")
    public ResponseEntity<List<VerExamenDTO>> verExamenesResueltos(@PathVariable int idEstudiante) throws Exception {
        List<VerExamenDTO> examenesCompletados = estudianteServicio.verListaExamenesResueltos(idEstudiante);
        return ResponseEntity.ok().body(examenesCompletados);
    }

    @GetMapping("/notificaciones/{idEstudiante}")
    public ResponseEntity<List<NotificacionDTO>> verNotificaciones(@PathVariable int idEstudiante) throws Exception {
        List<NotificacionDTO> notificaciones = estudianteServicio.verNotificaciones(idEstudiante);
        return ResponseEntity.ok().body(notificaciones);
    }

    @PostMapping("/listar-notas")
    public ResponseEntity<List<CalificacionDTO>> verNotas(@RequestBody List<Integer> listaIDCalificacion) throws Exception {
        List<CalificacionDTO> notas = estudianteServicio.verNotas(listaIDCalificacion);
        return ResponseEntity.ok().body(notas);
    }

    @GetMapping("/resolver-examen/{idExamen}")
    public ResponseEntity<List<PreguntaDTO>> resolverExamen(@PathVariable int idExamen) throws Exception {
        List<PreguntaDTO> preguntas = estudianteServicio.resolverExamen(idExamen);
        return ResponseEntity.ok().body(preguntas);
    }

    @PostMapping("/contestar-pregunta")
    public ResponseEntity<MensajeDTO<String>> contestarPregunta(@Valid @RequestBody ContestarPreguntaDTO contestarPreguntaDTO) throws Exception {
        estudianteServicio.contestarPregunta(contestarPreguntaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(true, "Pregunta contestada correctamente"));
    }


}
