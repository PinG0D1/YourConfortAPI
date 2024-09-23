package pe.edu.upc.yourconfort.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HU12Dto {
    private Long idInmueble;
    private String direccionInmueble;
    private float precioInmueble;
    private String descripcionPropiedad;
    private String tipoInmueble;
}
