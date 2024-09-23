package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Inmueble;
import pe.edu.upc.yourconfort.interfaces.IInmuebleService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class InmuebleController {
    @Autowired
    private IInmuebleService inmuebleService ;
    @GetMapping("/inmuebles")
    public List<InmuebleDto> obtenerInmuebles(){
        ModelMapper mapper = new ModelMapper();
        List<Inmueble> inmuebles= inmuebleService.obtenerInmuebles();
        List<InmuebleDto> inmuebleDtos = Arrays.asList(mapper.map(inmuebles, InmuebleDto[].class));
        return inmuebleDtos;
    }
    @PostMapping("/inmueble")
    public InmuebleDto registrar(@RequestBody InmuebleDto inmuebleDto){
        ModelMapper mapper = new ModelMapper();
        Inmueble inmueble;
        inmueble = mapper.map(inmuebleDto, Inmueble.class);
        inmueble = inmuebleService.registrar(inmueble);
        inmuebleDto = mapper.map(inmueble, InmuebleDto.class);
        return inmuebleDto;
    }
    @DeleteMapping("/inmueble/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        inmuebleService.eliminar(id);
    }
    @PutMapping("/inmueble")
    public ResponseEntity<InmuebleDto> actualizar(@RequestBody InmuebleDto inmuebleDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Inmueble inmueble = mapper.map(inmuebleDto, Inmueble.class);
            inmueble = inmuebleService.actualizar(inmueble);
            inmuebleDto = mapper.map(inmueble, InmuebleDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(inmuebleDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(inmuebleDto);
    }
    @GetMapping("/inmuebles/por-universidad")
    public List<HU12Dto> getInmueblesPorUniversidad(@RequestParam String nombreUniversidad) {
        return inmuebleService.getInmueblesPorUniversidad(nombreUniversidad);
    }
    @GetMapping("/inmuebles/rango-precios")
    public List<HU13Dto> getInmueblesPorRangoDePrecios(@RequestParam float precioMin, @RequestParam float precioMax) {
        return inmuebleService.getInmueblesByRangoDePrecios(precioMin, precioMax);
    }
    @GetMapping("/inmuebles/tipo-propiedad")
    public List<HU14Dto> getInmueblesPorTipoDePropiedad(@RequestParam String tipoInmueble) {
        return inmuebleService.getInmueblesByTipoDePropiedad(tipoInmueble);
    }
    @GetMapping("/inmuebles/ordenados-por-calificacion")
    public List<HU15Dto> getInmueblesOrdenadosPorCalificacion() {
        return inmuebleService.getInmueblesOrdenadosPorCalificacion();
    }
    @GetMapping("/inmuebles/ordenados-por-fecha")
    public List<HU16Dto> getInmueblesOrdenadosPorFechaPublicacion() {
        return inmuebleService.getInmueblesOrdenadosPorFechaPublicacion();
    }
    @GetMapping("/inmuebles/ordenados-por-precio-ascendente")
    public List<HU29Dto> getInmueblesOrdenadosPorPrecioAscendente(@RequestParam Long arrendadorId) {
        return inmuebleService.getInmueblesOrdenadosPorPrecioAscendente(arrendadorId);
    }

    @GetMapping("/inmuebles/ordenados-por-precio-descendente")
    public List<HU29Dto> getInmueblesOrdenadosPorPrecioDescendente(@RequestParam Long arrendadorId) {
        return inmuebleService.getInmueblesOrdenadosPorPrecioDescendente(arrendadorId);
    }
    @GetMapping("/inmuebles/cantidad-reservados")
    public HU31Dto getCantidadInmueblesReservados(@RequestParam Long arrendadorId) {
        return inmuebleService.getCantidadInmueblesReservados(arrendadorId);
    }
    @GetMapping("/inmuebles/totaldearrendador")
    public HU32Dto getCantidadTotalInmuebles(@RequestParam Long arrendadorId) {
        return inmuebleService.getCantidadTotalInmuebles(arrendadorId);
    }
//
    @GetMapping("/arrendador/contacto")
    public HU10Dto getContactoArrendador(@RequestParam Long inmuebleId) {
        return inmuebleService.getContactoArrendadorPorInmueble(inmuebleId);
    }
    @GetMapping("/inmuebles/disponibles")
    public List<HU11Dto> getInmueblesDisponibles() {
        return inmuebleService.getInmueblesDisponibles();
    }
    @GetMapping("/inmuebles/arrendador")
    public List<HU18Dto> getInmueblesPorArrendador(@RequestParam Long arrendadorId) {
        return inmuebleService.getInmueblesPorArrendador(arrendadorId);
    }
}
