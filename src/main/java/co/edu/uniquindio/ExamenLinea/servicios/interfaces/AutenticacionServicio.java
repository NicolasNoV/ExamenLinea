package co.edu.uniquindio.ExamenLinea.servicios.interfaces;

import co.edu.uniquindio.ExamenLinea.DTO.LoginDTO;
import co.edu.uniquindio.ExamenLinea.DTO.TokenDTO;

public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
