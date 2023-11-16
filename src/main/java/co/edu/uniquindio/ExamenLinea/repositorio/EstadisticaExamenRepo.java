package co.edu.uniquindio.ExamenLinea.repositorio;

import co.edu.uniquindio.ExamenLinea.modelo.entidades.EstadisticaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaExamenRepo extends JpaRepository<EstadisticaExamen, Integer> {
}
