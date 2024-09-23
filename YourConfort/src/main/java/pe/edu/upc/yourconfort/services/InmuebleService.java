package pe.edu.upc.yourconfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.yourconfort.dto.*;
import pe.edu.upc.yourconfort.entities.Inmueble;
import pe.edu.upc.yourconfort.interfaces.IInmuebleService;
import pe.edu.upc.yourconfort.respository.InmuebleRepository;

import java.util.List;

@Service
public class InmuebleService implements IInmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;
    @Override
    public List<Inmueble> obtenerInmuebles() {
        return inmuebleRepository.findAll();}
    @Override
    public Inmueble registrar(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);}
    @Override
    public void eliminar(Long id) throws Exception{
        if (inmuebleRepository.existsById(id)){
            inmuebleRepository.deleteById(id);
        }else {
            throw new Exception("No existe Inmueble");
        }
    }
    @Override
    public Inmueble actualizar(Inmueble inmueble) {
        if(inmuebleRepository.findById(inmueble.getId_Inmueble()).isPresent()){
            return inmuebleRepository.save(inmueble);
        }
        return null;
    }

    @Override
    public List<HU13Dto> getInmueblesByRangoDePrecios(float precioMin, float precioMax) {
        return inmuebleRepository.findInmueblesByRangoDePrecios(precioMin, precioMax);
    }
    @Override
    public List<HU14Dto> getInmueblesByTipoDePropiedad(String tipoInmueble) {
        return inmuebleRepository.findInmueblesByTipoDePropiedad(tipoInmueble);
    }
    @Override
    public List<HU15Dto> getInmueblesOrdenadosPorCalificacion() {
        return inmuebleRepository.findInmueblesOrdenadosPorCalificacion();
    }
    public List<HU16Dto> getInmueblesOrdenadosPorFechaPublicacion() {
        return inmuebleRepository.findInmueblesOrdenadosPorFechaPublicacion();
    }
    //
    @Override
    public List<HU29Dto> getInmueblesOrdenadosPorPrecioAscendente(Long arrendadorId) {
        return inmuebleRepository.findInmueblesOrdenadosPorPrecioAscendente(arrendadorId);
    }
    @Override
    public List<HU29Dto> getInmueblesOrdenadosPorPrecioDescendente(Long arrendadorId) {
        return inmuebleRepository.findInmueblesOrdenadosPorPrecioDescendente(arrendadorId);
    }
    @Override
    public HU31Dto getCantidadInmueblesReservados(Long arrendadorId) {
        return inmuebleRepository.countInmueblesReservadosByArrendador(arrendadorId);
    }
    @Override
    public HU32Dto getCantidadTotalInmuebles(Long arrendadorId) {
        return inmuebleRepository.countTotalInmueblesByArrendador(arrendadorId);
    }
//
    @Override
    public HU10Dto getContactoArrendadorPorInmueble(Long inmuebleId) {
    return inmuebleRepository.findContactoArrendadorByInmuebleId(inmuebleId)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró el inmueble con ese ID"));
}
    @Override
    public List<HU11Dto> getInmueblesDisponibles() {
        return inmuebleRepository.findAllInmueblesDisponibles();
    }
    @Override
    public List<HU12Dto> getInmueblesPorUniversidad(String nombreUniversidad) {
        return inmuebleRepository.findInmueblesByUniversidad(nombreUniversidad);
    }
    @Override
    public List<HU18Dto> getInmueblesPorArrendador(Long arrendadorId) {
        return inmuebleRepository.findInmueblesByArrendadorId(arrendadorId);
    }
}
