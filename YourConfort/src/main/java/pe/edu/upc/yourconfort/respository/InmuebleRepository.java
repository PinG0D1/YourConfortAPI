package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Inmueble;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

    //
    //

    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU13Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, i.tipo_Inmueble) " +
            "FROM Inmueble i WHERE i.precio_Inmueble BETWEEN :precioMin AND :precioMax")
    List<HU13Dto> findInmueblesByRangoDePrecios(float precioMin, float precioMax);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU14Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, i.tipo_Inmueble) " +
            "FROM Inmueble i WHERE i.tipo_Inmueble = :tipoInmueble")
    List<HU14Dto> findInmueblesByTipoDePropiedad(String tipoInmueble);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU15Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, AVG(c.calificacion)) " +
            "FROM Inmueble i JOIN i.comentarios c " +
            "GROUP BY i.id_Inmueble " +
            "ORDER BY AVG(c.calificacion) DESC")
    List<HU15Dto> findInmueblesOrdenadosPorCalificacion();
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU16Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, i.descripcion_Propiedad, i.tipo_Inmueble, i.fechaPublicacion) " +
            "FROM Inmueble i " +
            "WHERE i.estado_Propiedad = 'Disponible' " +
            "ORDER BY i.fechaPublicacion DESC")
    List<HU16Dto> findInmueblesOrdenadosPorFechaPublicacion();
    //
    // Query para ordenar inmuebles por precio en orden ascendente
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU29Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble) " +
            "FROM Inmueble i WHERE i.arrendador.id_Arrendador = :arrendadorId ORDER BY i.precio_Inmueble ASC")
    List<HU29Dto> findInmueblesOrdenadosPorPrecioAscendente(Long arrendadorId);

    // Query para ordenar inmuebles por precio en orden descendente
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU29Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble) " +
            "FROM Inmueble i WHERE i.arrendador.id_Arrendador = :arrendadorId ORDER BY i.precio_Inmueble DESC")
    List<HU29Dto> findInmueblesOrdenadosPorPrecioDescendente(Long arrendadorId);

    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU31Dto(i.arrendador.id_Arrendador, COUNT(i)) " +
            "FROM Inmueble i JOIN i.reservas r " +
            "WHERE i.arrendador.id_Arrendador = :arrendadorId " +
            "GROUP BY i.arrendador.id_Arrendador")
    HU31Dto countInmueblesReservadosByArrendador(Long arrendadorId);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU32Dto(i.arrendador.id_Arrendador, COUNT(i)) " +
            "FROM Inmueble i " +
            "WHERE i.arrendador.id_Arrendador = :arrendadorId " +
            "GROUP BY i.arrendador.id_Arrendador")
    HU32Dto countTotalInmueblesByArrendador(Long arrendadorId);

    //
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU10Dto(a.nombre_Arrendador, a.telefono_Arrendador, a.email_Arrendador) " +
            "FROM Inmueble i JOIN i.arrendador a " +
            "WHERE i.id_Inmueble = :inmuebleId")
    Optional<HU10Dto> findContactoArrendadorByInmuebleId(Long inmuebleId);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU11Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, i.descripcion_Propiedad, i.tipo_Inmueble) " +
            "FROM Inmueble i " +
            "WHERE i.estado_Propiedad = 'Disponible'")
    List<HU11Dto> findAllInmueblesDisponibles();
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU12Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, i.descripcion_Propiedad, i.tipo_Inmueble) " +
            "FROM Inmueble i JOIN i.universidad u " +
            "WHERE u.nombre = :nombreUniversidad AND i.estado_Propiedad = 'Disponible'")
    List<HU12Dto> findInmueblesByUniversidad(String nombreUniversidad);
    @Query("SELECT new pe.edu.upc.yourconfort.dto.HU18Dto(i.id_Inmueble, i.direccion_Inmueble, i.precio_Inmueble, i.descripcion_Propiedad, i.tipo_Inmueble, i.estado_Propiedad) " +
            "FROM Inmueble i " +
            "WHERE i.arrendador.id_Arrendador = :arrendadorId")
    List<HU18Dto> findInmueblesByArrendadorId(Long arrendadorId);
}
