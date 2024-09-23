package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.ContratoDto;
import pe.edu.upc.yourconfort.dto.HU23Dto;
import pe.edu.upc.yourconfort.dto.HU27Dto;
import pe.edu.upc.yourconfort.dto.HU30Dto;
import pe.edu.upc.yourconfort.entities.Contrato;
import pe.edu.upc.yourconfort.interfaces.IContratoService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ContratoController {
    @Autowired
    private IContratoService contratoService;
    @GetMapping("/contratos")
    public List<ContratoDto> obtenerComentarios(){
        ModelMapper mapper = new ModelMapper();
        List<Contrato> contratos= contratoService.obtenerContratos();
        List<ContratoDto> contratoDtos = Arrays.asList(mapper.map(contratos, ContratoDto[].class));
        return contratoDtos;
    }
    @PostMapping("/contrato")
    public ContratoDto registrar(@RequestBody ContratoDto contratoDto){
        ModelMapper mapper = new ModelMapper();
        Contrato contrato;
        contrato = mapper.map(contratoDto, Contrato.class);
        contrato = contratoService.registrar(contrato);
        contratoDto = mapper.map(contrato, ContratoDto.class);
        return contratoDto;
    }
    @DeleteMapping("/contrato/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        contratoService.eliminar(id);
    }
    @PutMapping("/contrato")
    public ResponseEntity<ContratoDto> actualizar(@RequestBody ContratoDto contratoDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Contrato contrato = mapper.map(contratoDto, Contrato.class);
            contrato = contratoService.actualizar(contrato);
            contratoDto = mapper.map(contrato, ContratoDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(contratoDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(contratoDto);
    }
    @GetMapping("/universitarios/por-contrato")
    public Optional<HU27Dto> getUniversitarioPorContrato(@RequestParam Long idContrato) {
        return contratoService.getUniversitarioPorContrato(idContrato);
    }
    @GetMapping("/contratos/buscar")
    public HU30Dto getContratoPorId(@RequestParam Long contratoId) {
        return contratoService.getContratoPorId(contratoId);
    }
    @GetMapping("/contratos/arrendador")
    public List<HU23Dto> getContratosPorArrendador(@RequestParam Long arrendadorId) {
        return contratoService.getContratosPorArrendador(arrendadorId);
    }
}
