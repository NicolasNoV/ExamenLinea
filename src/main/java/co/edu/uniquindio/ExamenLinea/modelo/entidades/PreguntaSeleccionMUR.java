package co.edu.uniquindio.ExamenLinea.modelo.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaSeleccionMUR extends Pregunta implements Serializable {
}
