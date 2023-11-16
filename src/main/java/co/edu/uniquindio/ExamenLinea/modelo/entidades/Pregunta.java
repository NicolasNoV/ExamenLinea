package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private double porcentaje;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime tiempo;

    @NotBlank
    @Column(nullable = false)
    private String texto;

    @NotNull
    @OneToOne
    @JoinColumn(name = "tipoPregunta_id")
    private TipoPregunta tipoPregunta;

    @ManyToMany
    @JoinColumn(name = "examen_id")
    private List<Examen> examen;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
