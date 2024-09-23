package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU21Dto(r.id_Reserva, r.fecha_Reserva, i.direccion_Inmueble, r.comentario, u.nombre_Universitario) " +
            "FROM Reserva r JOIN r.inmueble i JOIN i.arrendador a JOIN r.universitario u " +
            "WHERE a.id_Arrendador = :arrendadorId")
    List<HU21Dto> findReservasDisponiblesPorArrendador(Long arrendadorId);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU26Dto(r.id_Reserva, r.fecha_Reserva, i.direccion_Inmueble, u.nombre_Universitario) " +
            "FROM Reserva r JOIN r.inmueble i JOIN i.arrendador a JOIN r.universitario u " +
            "WHERE a.id_Arrendador = :arrendadorId AND r.fecha_Reserva BETWEEN :fechaInicio AND :fechaFin")
    List<HU26Dto> findReservasPorRangoDeFechas(Long arrendadorId, LocalDate fechaInicio, LocalDate fechaFin);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU28Dto(r.id_Reserva, r.fecha_Reserva, i.direccion_Inmueble, u.nombre_Universitario) " +
            "FROM Reserva r JOIN r.inmueble i JOIN i.arrendador a JOIN r.universitario u " +
            "WHERE a.id_Arrendador = :arrendadorId " +
            "ORDER BY r.fecha_Reserva DESC")
    List<HU28Dto> findReservasMasRecientes(Long arrendadorId);

    //

    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU4Dto(r.id_Reserva, r.fecha_Reserva, i.direccion_Inmueble, r.comentario) " +
            "FROM Reserva r JOIN r.inmueble i " +
            "WHERE r.universitario.id_Universitario = :universitarioId")
    List<HU4Dto> findReservasByUniversitarioId(Long universitarioId);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU25Dto(r.id_Reserva, r.fecha_Reserva, r.comentario, i.direccion_Inmueble, u.nombre_Universitario) " +
            "FROM Reserva r JOIN r.inmueble i JOIN r.universitario u " +
            "WHERE r.id_Reserva = :reservaId")
    Optional<HU25Dto> findReservaById(Long reservaId);
}
