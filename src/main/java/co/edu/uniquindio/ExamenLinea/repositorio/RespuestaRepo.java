package co.edu.uniquindio.ExamenLinea.repositorio;

import co.edu.uniquindio.ExamenLinea.modelo.entidades.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepo extends JpaRepository<Respuesta, Integer> {
}
