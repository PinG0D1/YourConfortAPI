package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.yourconfort.dto.HU22Dto;
import pe.edu.upc.yourconfort.dto.HU8Dto;
import pe.edu.upc.yourconfort.entities.Comentario;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU22Dto(c.id_Comentario, c.contenido, c.calificacion, c.fecha, u.nombre_Universitario, i.direccion_Inmueble) " +
            "FROM Comentario c JOIN c.universitario u JOIN c.inmueble i JOIN i.arrendador a " +
            "WHERE a.id_Arrendador = :arrendadorId")
    List<HU22Dto> findComentariosPorArrendador(Long arrendadorId);

    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU8Dto(c.id_Comentario, c.contenido, c.calificacion, c.fecha, u.nombre_Universitario) " +
            "FROM Comentario c JOIN c.universitario u JOIN c.inmueble i " +
            "WHERE i.id_Inmueble = :inmuebleId")
    List<HU8Dto> findComentariosByInmuebleId(Long inmuebleId);
}
