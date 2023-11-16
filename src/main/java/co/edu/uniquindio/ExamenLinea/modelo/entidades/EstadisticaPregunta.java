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
public class EstadisticaPregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private double porcentajeCorrecto;

    @NotNull
    @Column(nullable = false)
    private int correctas;

    @NotNull
    @Column(nullable = false)
    private int incorrectas;

    @NotNull
    @Column(nullable = false)
    private int contestadas;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
