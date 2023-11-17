package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoExamen;
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
public class Examen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String descripcion;

    @NotBlank
    @Column(nullable = false)
    private String categoria;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoExamen estadoExamen;

    @NotNull
    @Column(nullable = false)
    private int cantidadPreguntasBanco;

    @NotNull
    @Column(nullable = false)
    private int cantidadPreguntasEstudiante;


    @NotNull
    @Column(nullable = false)
    private LocalDateTime tiempoLimite;

    private LocalDateTime tiempoTranscurrido;

    @NotNull
    @OneToOne
    @JoinColumn(name = "diaEvaluacion_id")
    private DiaEvaluacion diaEvaluacion;

    @OneToOne
    @JoinColumn(name = "configuracion_id")
    private Configuracion configuracion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
