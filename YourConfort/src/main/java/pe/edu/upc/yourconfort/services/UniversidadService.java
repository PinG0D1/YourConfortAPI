package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.entities.Universidad;
import pe.edu.upc.yourconfort.interfaces.IUniversidadService;
import pe.edu.upc.yourconfort.respository.UniversidadRepository;

import java.util.List;
@Service
public class UniversidadService implements IUniversidadService {
    @Autowired
    private UniversidadRepository universidadRepository;

    public List<Universidad> obtenerUniversidades() {
        return universidadRepository.findAll();}
    @Override
    public Universidad registrar(Universidad universidad) {
        return universidadRepository.save(universidad);}
    @Override
    public void eliminar(Long id) throws Exception{
        if (universidadRepository.existsById(id)){
            universidadRepository.deleteById(id);
        }else {
            throw new Exception("No existe Universidad");
        }
    }
    @Override
    public Universidad actualizar(Universidad universidad) {
        if(universidadRepository.findById(universidad.getId_Universidad()).isPresent()){
            return universidadRepository.save(universidad);
        }
        return null;
    }
}
