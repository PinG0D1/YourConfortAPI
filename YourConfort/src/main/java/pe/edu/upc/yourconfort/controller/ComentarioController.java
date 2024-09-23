package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.ComentarioDto;
import pe.edu.upc.yourconfort.dto.HU8Dto;
import pe.edu.upc.yourconfort.entities.Comentario;
import pe.edu.upc.yourconfort.interfaces.IComentarioService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class ComentarioController {
    @Autowired
    private IComentarioService comentarioService;
    @GetMapping("/comentarios")
    public List<ComentarioDto> obtenerComentarios(){
        ModelMapper mapper = new ModelMapper();
        List<Comentario> comentarios= comentarioService.obetenerComentarios();
        List<ComentarioDto> comentarioDtos = Arrays.asList(mapper.map(comentarios, ComentarioDto[].class));
        return comentarioDtos;
    }
    @PostMapping("/comentario")
    public ComentarioDto registrar(@RequestBody ComentarioDto comentarioDto){
        ModelMapper mapper = new ModelMapper();
        Comentario comentario;
        comentario = mapper.map(comentarioDto, Comentario.class);
        comentario = comentarioService.registrar(comentario);
        comentarioDto = mapper.map(comentario, ComentarioDto.class);
        return comentarioDto;
    }
    @DeleteMapping("/comentario/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        comentarioService.eliminar(id);
    }
    @PutMapping("/comentario")
    public ResponseEntity<ComentarioDto> actualizar(@RequestBody ComentarioDto comentarioDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Comentario comentario = mapper.map(comentarioDto, Comentario.class);
            comentario= comentarioService.actualizar(comentario);
            comentarioDto = mapper.map(comentario, ComentarioDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(comentarioDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(comentarioDto);
    }
    @GetMapping("/comentarios/inmueble")
    public List<HU8Dto> getComentariosPorInmueble(@RequestParam Long inmuebleId) {
        return comentarioService.getComentariosPorInmueble(inmuebleId);
    }
}
