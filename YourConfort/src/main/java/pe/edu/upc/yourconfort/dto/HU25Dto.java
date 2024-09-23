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
public class HU25Dto {
    private Long idReserva;
    private LocalDate fechaReserva;
    private String comentario;
    private String direccionInmueble;
    private String nombreUniversitario;
}
