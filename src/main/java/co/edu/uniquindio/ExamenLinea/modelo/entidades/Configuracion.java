package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Configuracion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private double porcentaje;

    @NotNull
    @Column(nullable = false)
    private double umbral;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime hora;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha;

    @NotNull
    @Column(nullable = false)
    private int numeroPreguntas;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime tiempo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
