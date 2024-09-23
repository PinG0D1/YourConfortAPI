package pe.edu.upc.yourconfort.interfaces;

import pe.edu.upc.yourconfort.dto.HU23Dto;
import pe.edu.upc.yourconfort.dto.HU27Dto;
import pe.edu.upc.yourconfort.dto.HU30Dto;
import pe.edu.upc.yourconfort.entities.Contrato;

import java.util.List;
import java.util.Optional;

public interface IContratoService {
    public List<Contrato> obtenerContratos();
    public Contrato registrar(Contrato contrato);
    public void eliminar(Long id) throws Exception;
    public Contrato actualizar(Contrato contrato);
    public Optional<HU27Dto> getUniversitarioPorContrato(Long idContrato);
    public HU30Dto getContratoPorId(Long contratoId);
    public List<HU23Dto> getContratosPorArrendador(Long arrendadorId);
}
