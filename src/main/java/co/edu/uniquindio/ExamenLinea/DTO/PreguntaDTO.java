package co.edu.uniquindio.ExamenLinea.DTO;

import co.edu.uniquindio.ExamenLinea.modelo.entidades.TipoPregunta;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PreguntaDTO(

        double porcentaje,
        LocalDateTime tiempo,
        String texto,
        TipoPreguntaDTO tipoPreguntaDTO

) {
}
