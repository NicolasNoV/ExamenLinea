package co.edu.uniquindio.ExamenLinea.repositorio;

import co.edu.uniquindio.ExamenLinea.modelo.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepo extends JpaRepository<Pregunta, Integer> {
}
