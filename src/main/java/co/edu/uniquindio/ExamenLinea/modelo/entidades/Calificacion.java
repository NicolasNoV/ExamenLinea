package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private double nota;

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
