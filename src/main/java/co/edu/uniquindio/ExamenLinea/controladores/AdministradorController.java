package co.edu.uniquindio.ExamenLinea.controladores;

import co.edu.uniquindio.ExamenLinea.DTO.MensajeDTO;
import co.edu.uniquindio.ExamenLinea.DTO.administrador.*;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/administrador")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorServicio administradorServicio;

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
    @GetMapping("/buscar-profesor/{idEstudiante}")
    public ResponseEntity<MensajeDTO<EstudianteDTO>> buscarEstudianteId(@PathVariable int idEstudiante) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.buscarEstudianteId(idEstudiante)));
    }

}
