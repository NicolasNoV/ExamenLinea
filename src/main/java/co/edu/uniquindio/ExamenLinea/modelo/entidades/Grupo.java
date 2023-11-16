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
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @OneToOne
    @JoinColumn(name = "planEstudio_id")
    private PlanEstudio planEstudio;

    @NotNull
    @OneToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @NotNull
    @OneToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;
}
