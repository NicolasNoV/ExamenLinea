package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticaExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha;

    @NotNull
    @Column(nullable = false)
    private double puntaje;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime tiempoTranscurrido;

    @NotBlank
    @Column(nullable = false)
    private String direccionIP;

    @NotNull
    @OneToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    @NotNull
    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;
}
