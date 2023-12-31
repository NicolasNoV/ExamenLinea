package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dia;

    @NotNull
    @Column(nullable = false)
    private LocalTime hora;

    @NotBlank
    @Column(nullable = false)
    private String lugar;

    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;
}
