package pe.edu.upc.yourconfort.interfaces;
import pe.edu.upc.yourconfort.entities.Arrendador;

import java.util.List;

public interface IArrendadorService {
    public List<Arrendador> obtenerArrendadores();
    public Arrendador registrar(Arrendador arrendador);
    public void eliminar(Long id) throws Exception;
    public Arrendador actualizar(Arrendador arrendador);
}
