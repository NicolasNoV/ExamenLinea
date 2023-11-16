package co.edu.uniquindio.ExamenLinea.repositorio;

import co.edu.uniquindio.ExamenLinea.modelo.entidades.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepo extends JpaRepository<Examen, Integer> {
}
