package pe.edu.upc.yourconfort.interfaces;
import pe.edu.upc.yourconfort.dto.HU22Dto;
import pe.edu.upc.yourconfort.dto.HU8Dto;
import pe.edu.upc.yourconfort.entities.Comentario;

import java.util.List;

public interface IComentarioService {
    public List<Comentario> obetenerComentarios();
    public Comentario registrar(Comentario comentario);
    public void eliminar(Long id) throws Exception;
    public Comentario actualizar(Comentario comentario);
    public List<HU22Dto> getComentariosPorArrendador(Long arrendadorId);

    //
    public List<HU8Dto> getComentariosPorInmueble(Long inmuebleId);
}
