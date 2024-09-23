package pe.edu.upc.yourconfort.interfaces;

import pe.edu.upc.yourconfort.dto.HU21Dto;
import pe.edu.upc.yourconfort.entities.Inmueble;
import pe.edu.upc.yourconfort.entities.Universidad;

import java.util.List;

public interface IUniversidadService {
    public List<Universidad> obtenerUniversidades();
    public Universidad registrar(Universidad universidad);
    public void eliminar(Long id) throws Exception;
    public Universidad actualizar(Universidad universidad);

}
