package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.ArrendadorDto;
import pe.edu.upc.yourconfort.entities.Arrendador;
import pe.edu.upc.yourconfort.interfaces.IArrendadorService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class ArrendadorController {
    @Autowired
    private IArrendadorService arrendadorService;
    @GetMapping("/arrendadores")
    public List<ArrendadorDto> obtenerArrendadores(){
        ModelMapper mapper = new ModelMapper();
        List<Arrendador> arrendadores = arrendadorService.obtenerArrendadores();
        List<ArrendadorDto> arrendadorDtos = Arrays.asList(mapper.map(arrendadores, ArrendadorDto[].class));
        return arrendadorDtos;
    }
    @PostMapping("/arrendador")
    public ArrendadorDto registrar(@RequestBody ArrendadorDto arrendadorDto){
        ModelMapper mapper = new ModelMapper();
        Arrendador arrendador;
        arrendador = mapper.map(arrendadorDto, Arrendador.class);
        arrendador = arrendadorService.registrar(arrendador);
        arrendadorDto = mapper.map(arrendador, ArrendadorDto.class);
        return arrendadorDto;
    }
    @DeleteMapping("/arrendador/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        arrendadorService.eliminar(id);
    }
    @PutMapping("/arredador")
    public ResponseEntity<ArrendadorDto> actualizar(@RequestBody ArrendadorDto arrendadorDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Arrendador arrendador = mapper.map(arrendadorDto, Arrendador.class);
            arrendador = arrendadorService.actualizar(arrendador);
            arrendadorDto = mapper.map(arrendador, ArrendadorDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(arrendadorDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(arrendadorDto);
    }

}
