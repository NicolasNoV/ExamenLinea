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
public class PlanEstudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @Column(nullable = false)
    private int unidades;

    @NotBlank
    @Column(nullable = false)
    private String contenido;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEntidad estado;

}
