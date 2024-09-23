package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.UniversidadDto;
import pe.edu.upc.yourconfort.entities.Contrato;
import pe.edu.upc.yourconfort.entities.Universidad;
import pe.edu.upc.yourconfort.interfaces.IUniversidadService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class UniversidadController {
    @Autowired
    private IUniversidadService universidadService;
    @GetMapping("/universidades")
    public List<UniversidadDto> obtenerUniversidades() {
        ModelMapper mapper = new ModelMapper();
        List<Universidad> universidades= universidadService.obtenerUniversidades();
        List<UniversidadDto> universidadDtos = Arrays.asList(mapper.map(universidades, UniversidadDto[].class));
        return universidadDtos;
    }
    @PostMapping("/universidad")
    public UniversidadDto registrar(@RequestBody UniversidadDto universidadDto){
        ModelMapper mapper = new ModelMapper();
        Universidad universidad;
        universidad = mapper.map(universidadDto, Universidad.class);
        universidad = universidadService.registrar(universidad);
        universidadDto = mapper.map(universidadDto, UniversidadDto.class);
        return universidadDto;
    }
    @DeleteMapping("/universidad/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        universidadService.eliminar(id);
    }
    @PutMapping("/universidad")
    public ResponseEntity<UniversidadDto> actualizar(@RequestBody UniversidadDto universidadDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Universidad universidad = mapper.map(universidadDto, Universidad.class);
            universidad = universidadService.actualizar(universidad);
            universidadDto = mapper.map(universidad, UniversidadDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(universidadDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(universidadDto);
    }
}
