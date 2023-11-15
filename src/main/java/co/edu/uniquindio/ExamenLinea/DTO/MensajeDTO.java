package co.edu.uniquindio.ExamenLinea.DTO;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}