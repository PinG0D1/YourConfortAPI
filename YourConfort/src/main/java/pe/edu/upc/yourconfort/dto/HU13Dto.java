package pe.edu.upc.yourconfort.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HU13Dto {
    private Long id_Inmueble;
    private String direccion_Inmueble;
    private float precio_Inmueble;
    private String tipo_Inmueble;
}
