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
public class HU21Dto {
    private Long id_Reserva;
    private LocalDate fecha_Reserva;
    private String direccion_Inmueble;
    private String estado_Reserva;
    private String nombreUniversitario;
}