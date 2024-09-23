package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.entities.Universitario;
import pe.edu.upc.yourconfort.interfaces.IUniversitarioService;
import pe.edu.upc.yourconfort.respository.UniversitarioRepository;

import java.util.List;
@Service
public class UniversitarioService implements IUniversitarioService {
    @Autowired
    private UniversitarioRepository universitarioRepository;
    @Override
    public List<Universitario> obtenerUniversitarios() {
        return universitarioRepository.findAll();}

    @Override
    public Universitario registrar(Universitario universitario) {
        return universitarioRepository.save(universitario);}
    @Override
    public void eliminar(Long id) throws Exception{
        if (universitarioRepository.existsById(id)){
            universitarioRepository.deleteById(id);
        }else {
            throw new Exception("No existe Universitario");
        }
    }
    @Override
    public Universitario actualizar(Universitario universitario) {
        if(universitarioRepository.findById(universitario.getId_Universitario()).isPresent()){
            return universitarioRepository.save(universitario);
        }
        return null;
    }




}
