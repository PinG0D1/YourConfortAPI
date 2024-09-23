package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.UniversitarioDto;
import pe.edu.upc.yourconfort.entities.Contrato;
import pe.edu.upc.yourconfort.entities.Universitario;
import pe.edu.upc.yourconfort.interfaces.IUniversitarioService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class UniversitarioController {
    @Autowired
    private IUniversitarioService universitarioService;
    @GetMapping("/universitarios")
    public List<UniversitarioDto> obtenerUniversitarios() {
        ModelMapper mapper = new ModelMapper();
        List<Universitario> universitarios= universitarioService.obtenerUniversitarios();
        List<UniversitarioDto> universitarioDtos = Arrays.asList(mapper.map(universitarios, UniversitarioDto[].class));
        return universitarioDtos;
    }
    @PostMapping("/universitario")
    public UniversitarioDto registrar(@RequestBody UniversitarioDto universitarioDto){
        ModelMapper mapper = new ModelMapper();
        Universitario universitario;
        universitario = mapper.map(universitarioDto, Universitario.class);
        universitario = universitarioService.registrar(universitario);
        universitarioDto = mapper.map(universitario, UniversitarioDto.class);
        return universitarioDto;
    }
    @DeleteMapping("/universitario/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        universitarioService.eliminar(id);
    }
    @PutMapping("/universitario")
    public ResponseEntity<UniversitarioDto> actualizar(@RequestBody UniversitarioDto universitarioDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Universitario universitario = mapper.map(universitarioDto, Universitario.class);
            universitario = universitarioService.actualizar(universitario);
            universitarioDto = mapper.map(universitario, UniversitarioDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(universitarioDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(universitarioDto);
    }
}
