package pe.edu.upc.yourconfort.interfaces;

import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {
    public List<Reserva> obtenerReservas();
    public Reserva registrar(Reserva reserva);
    public void eliminar(Long id) throws Exception;
    public Reserva actualizar(Reserva reserva);
    public List<HU21Dto> getReservasDisponiblesPorArrendador(Long arrendadorId);
    public List<HU26Dto> getReservasPorRangoDeFechas(Long arrendadorId, LocalDate fechaInicio, LocalDate fechaFin);
    public List<HU28Dto> getReservasMasRecientes(Long arrendadorId);
    //
    public List<HU4Dto> getReservasPorUniversitario(Long universitarioId);
    public HU25Dto getReservaPorId(Long reservaId);
}
