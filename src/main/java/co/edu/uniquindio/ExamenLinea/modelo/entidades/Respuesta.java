package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import co.edu.uniquindio.ExamenLinea.modelo.enums.TipoRespuesta;
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
public class Respuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank
    @Column(nullable = false)
    private String respuesta;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoRespuesta tipoRespuesta;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
