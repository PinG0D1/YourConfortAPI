package pe.edu.upc.yourconfort.interfaces;

import pe.edu.upc.yourconfort.entities.Universitario;

import java.util.List;

public interface IUniversitarioService {
    public List<Universitario> obtenerUniversitarios();
    public Universitario registrar(Universitario universitario);
    public void eliminar(Long id) throws Exception;
    public Universitario actualizar(Universitario universitario);
}
