package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.yourconfort.dto.HU23Dto;
import pe.edu.upc.yourconfort.dto.HU27Dto;
import pe.edu.upc.yourconfort.dto.HU30Dto;
import pe.edu.upc.yourconfort.entities.Contrato;

import java.util.List;
import java.util.Optional;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU27Dto(c.id_Contrato, u.nombre_Universitario, u.email_Universitario, u.telefono_Universitario, c.fecha_Contrato) " +
            "FROM Contrato c JOIN c.reserva r JOIN r.universitario u " +
            "WHERE c.id_Contrato = :idContrato")
    Optional<HU27Dto> findUniversitarioPorContrato(Long idContrato);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU30Dto(c.id_Contrato, c.fecha_Contrato, c.comentario, i.direccion_Inmueble, u.nombre_Universitario) " +
            "FROM Contrato c JOIN c.reserva r JOIN r.inmueble i JOIN r.universitario u " +
            "WHERE c.id_Contrato = :contratoId")
    Optional<HU30Dto> findContratoById(Long contratoId);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU23Dto(c.id_Contrato, c.fecha_Contrato, c.comentario, i.direccion_Inmueble, u.nombre_Universitario) " +
            "FROM Contrato c JOIN c.reserva r JOIN r.inmueble i JOIN r.universitario u " +
            "WHERE i.arrendador.id_Arrendador = :arrendadorId")
    List<HU23Dto> findContratosByArrendadorId(Long arrendadorId);
}
