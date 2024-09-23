package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.entities.Arrendador;
import pe.edu.upc.yourconfort.interfaces.IArrendadorService;
import pe.edu.upc.yourconfort.respository.ArrendadorRepository;

import java.util.List;

@Service
public class ArrendadorService implements IArrendadorService {
    @Autowired
    private ArrendadorRepository arrendadorRepository;
    @Override
    public List<Arrendador> obtenerArrendadores() {
        return arrendadorRepository.findAll();}
    @Override
    public Arrendador registrar(Arrendador arrendador) {
        return arrendadorRepository.save(arrendador);}
    @Override
    public void eliminar(Long id) throws Exception{
        if (arrendadorRepository.existsById(id)){
            arrendadorRepository.deleteById(id);
        }else {
            throw new Exception("No existe Arrendador");
        }
    }
    @Override
    public Arrendador actualizar(Arrendador arrendador) {
        if(arrendadorRepository.findById(arrendador.getId_Arrendador()).isPresent()){
            return arrendadorRepository.save(arrendador);
        }
        return null;
    }
}
