package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.dto.HU22Dto;
import pe.edu.upc.yourconfort.dto.HU8Dto;
import pe.edu.upc.yourconfort.entities.Comentario;
import pe.edu.upc.yourconfort.interfaces.IComentarioService;
import pe.edu.upc.yourconfort.respository.ComentarioRepository;

import java.util.List;
@Service
public class ComentarioService implements IComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> obetenerComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario registrar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
        } else {
            throw new Exception("No existe Comentario");
        }
    }

    @Override
    public Comentario actualizar(Comentario comentario) {
        if (comentarioRepository.findById(comentario.getId_Comentario()).isPresent()) {
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    @Override
    public List<HU22Dto> getComentariosPorArrendador(Long arrendadorId) {
        return comentarioRepository.findComentariosPorArrendador(arrendadorId);
    }
    @Override
    public List<HU8Dto> getComentariosPorInmueble(Long inmuebleId) {
        return comentarioRepository.findComentariosByInmuebleId(inmuebleId);
    }
}
