package co.edu.uniquindio.ExamenLinea.repositorio;

import co.edu.uniquindio.ExamenLinea.modelo.entidades.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepo extends JpaRepository<Notificacion, Integer> {
}
