package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.dto.HU23Dto;
import pe.edu.upc.yourconfort.dto.HU27Dto;
import pe.edu.upc.yourconfort.dto.HU30Dto;
import pe.edu.upc.yourconfort.entities.Contrato;
import pe.edu.upc.yourconfort.interfaces.IContratoService;
import pe.edu.upc.yourconfort.respository.ContratoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService implements IContratoService {
    @Autowired
    private ContratoRepository contratoRepository;
    @Override
    public List<Contrato> obtenerContratos() {
        return contratoRepository.findAll();}
    @Override
    public Contrato registrar(Contrato contrato) {
        return contratoRepository.save(contrato);}
    @Override
    public void eliminar(Long id) throws Exception{
        if (contratoRepository.existsById(id)){
            contratoRepository.deleteById(id);
        }else {
            throw new Exception("No existe Contrato");
        }
    }
    @Override
    public Contrato actualizar(Contrato contrato) {
        if(contratoRepository.findById(contrato.getId_Contrato()).isPresent()){
            return contratoRepository.save(contrato);
        }
        return null;
    }
    @Override
    public Optional<HU27Dto> getUniversitarioPorContrato(Long idContrato) {
        return contratoRepository.findUniversitarioPorContrato(idContrato);
    }
    @Override
    public HU30Dto getContratoPorId(Long contratoId) {
        return contratoRepository.findContratoById(contratoId)
                .orElseThrow(() -> new IllegalArgumentException("Contrato no encontrado"));
    }
    @Override
    public List<HU23Dto> getContratosPorArrendador(Long arrendadorId) {
        return contratoRepository.findContratosByArrendadorId(arrendadorId);
    }
}
