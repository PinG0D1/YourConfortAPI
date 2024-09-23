package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Reserva;
import pe.edu.upc.yourconfort.interfaces.IReservaService;
import pe.edu.upc.yourconfort.respository.ReservaRepository;

import java.time.LocalDate;
import java.util.List;
@Service
public class ReservaService implements IReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Override
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();}
    @Override
    public Reserva registrar(Reserva reserva) {
        return reservaRepository.save(reserva);}
    @Override
    public void eliminar(Long id) throws Exception{
        if (reservaRepository.existsById(id)){
            reservaRepository.deleteById(id);
        }else {
            throw new Exception("No existe Reserva");
        }
    }
    @Override
    public Reserva actualizar(Reserva reserva) {
        if(reservaRepository.findById(reserva.getId_Reserva()).isPresent()){
            return reservaRepository.save(reserva);
        }
        return null;
    }
    public List<HU21Dto> getReservasDisponiblesPorArrendador(Long arrendadorId) {
        return reservaRepository.findReservasDisponiblesPorArrendador(arrendadorId);
    }
    @Override
    public List<HU26Dto> getReservasPorRangoDeFechas(Long arrendadorId, LocalDate fechaInicio, LocalDate fechaFin) {
        return reservaRepository.findReservasPorRangoDeFechas(arrendadorId, fechaInicio, fechaFin);
    }
    @Override
    public List<HU28Dto> getReservasMasRecientes(Long arrendadorId) {
        return reservaRepository.findReservasMasRecientes(arrendadorId);
    }
    //
    @Override
    public List<HU4Dto> getReservasPorUniversitario(Long universitarioId) {
        return reservaRepository.findReservasByUniversitarioId(universitarioId);
    }
    @Override
    public HU25Dto getReservaPorId(Long reservaId) {
        return reservaRepository.findReservaById(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));
    }
}
