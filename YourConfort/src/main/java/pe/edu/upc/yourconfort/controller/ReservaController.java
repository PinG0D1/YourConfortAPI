package pe.edu.upc.yourconfort.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Reserva;
import pe.edu.upc.yourconfort.interfaces.IReservaService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReservaController {
    @Autowired
    private IReservaService reservaService;
    @GetMapping("/reservas")
    public List<ReservaDto> obtenerReservas(){
        ModelMapper mapper = new ModelMapper();
        List<Reserva> reservas= reservaService.obtenerReservas();
        List<ReservaDto> reservaDtos = Arrays.asList(mapper.map(reservas, ReservaDto[].class));
        return reservaDtos;
    }
    @PostMapping("/reserva")
    public ReservaDto registrar(@RequestBody ReservaDto reservaDto){
        ModelMapper mapper = new ModelMapper();
        Reserva reserva;
        reserva = mapper.map(reservaDto, Reserva.class);
        reserva = reservaService.registrar(reserva);
        reservaDto = mapper.map(reservaDto, ReservaDto.class);
        return reservaDto;
    }
    @DeleteMapping("/reserva/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        reservaService.eliminar(id);
    }
    @PutMapping("/reserva")
    public ResponseEntity<ReservaDto> actualizar(@RequestBody ReservaDto reservaDto){
        ModelMapper mapper = new ModelMapper();
        try {
            Reserva reserva = mapper.map(reservaDto, Reserva.class);
            reserva = reservaService.actualizar(reserva);
            reservaDto = mapper.map(reserva, ReservaDto.class);
        }catch(Exception e){
            return new ResponseEntity<>(reservaDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservaDto);
    }
    @GetMapping("/reservas/arrendador/disponibles")
    public List<HU21Dto> getReservasDisponiblesPorArrendador(@RequestParam Long arrendadorId) {
        return reservaService.getReservasDisponiblesPorArrendador(arrendadorId);
    }
    @GetMapping("/reservas/arrendador/rango-fechas")
    public List<HU26Dto> getReservasPorRangoDeFechas(
            @RequestParam Long arrendadorId,
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        return reservaService.getReservasPorRangoDeFechas(arrendadorId, fechaInicio, fechaFin);
    }
    @GetMapping("/reservas/arrendador/recientes")
    public List<HU28Dto> getReservasMasRecientes(@RequestParam Long arrendadorId) {
        return reservaService.getReservasMasRecientes(arrendadorId);
    }

    //
    @GetMapping("/reservas/universitario")
    public List<HU4Dto> getReservasPorUniversitario(@RequestParam Long universitarioId) {
        return reservaService.getReservasPorUniversitario(universitarioId);
    }
    @GetMapping("/reservas/buscar")
    public HU25Dto getReservaPorId(@RequestParam Long reservaId) {
        return reservaService.getReservaPorId(reservaId);
    }
}
