package pe.edu.upc.yourconfort.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HU16Dto {
    private Long idInmueble;
    private String direccionInmueble;
    private float precioInmueble;
    private String descripcionPropiedad;
    private String tipoInmueble;
    private LocalDate fechaPublicacion;
}
