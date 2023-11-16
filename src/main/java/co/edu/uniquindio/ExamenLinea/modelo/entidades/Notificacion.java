package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank
    @Column(nullable = false)
    private String notificacion;

    @NotNull
    @OneToOne
    @JoinColumn(name = "calificacion_id")
    private Calificacion calificacion;

    @NotNull
    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;
}
