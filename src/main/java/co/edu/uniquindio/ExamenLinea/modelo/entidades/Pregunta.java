package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private double porcentaje;

    @NotBlank
    @Column(nullable = false)
    private String tipoPregunta;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime tiempo;

    @NotBlank
    @Column(nullable = false)
    private String pregunta;

    @ManyToMany
    @JoinColumn(name = "examen_id")
    private List<Examen> examen;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
