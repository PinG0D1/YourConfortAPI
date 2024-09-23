package pe.edu.upc.yourconfort.interfaces;

import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Inmueble;

import java.time.LocalDate;
import java.util.List;

public interface IInmuebleService {
    public List<Inmueble> obtenerInmuebles();
    public Inmueble registrar(Inmueble inmueble);
    public void eliminar(Long id) throws Exception;
    public Inmueble actualizar(Inmueble inmueble);
//
    public List<HU13Dto> getInmueblesByRangoDePrecios(float precioMin, float precioMax);
    public List<HU14Dto> getInmueblesByTipoDePropiedad(String tipoInmueble);
    public List<HU15Dto> getInmueblesOrdenadosPorCalificacion();
    public List<HU16Dto> getInmueblesOrdenadosPorFechaPublicacion();
    public List<HU29Dto> getInmueblesOrdenadosPorPrecioAscendente(Long arrendadorId);
    public List<HU29Dto> getInmueblesOrdenadosPorPrecioDescendente(Long arrendadorId);
    //
    public HU31Dto getCantidadInmueblesReservados(Long arrendadorId);
    public HU32Dto getCantidadTotalInmuebles(Long arrendadorId);
    //
    public HU10Dto getContactoArrendadorPorInmueble(Long inmuebleId);
    public List<HU11Dto> getInmueblesDisponibles();
    public List<HU12Dto> getInmueblesPorUniversidad(String nombreUniversidad);
    public List<HU18Dto> getInmueblesPorArrendador(Long arrendadorId);
}
