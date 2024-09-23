package pe.edu.upc.yourconfort.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.yourconfort.entities.Contrato;
import pe.edu.upc.yourconfort.entities.Inmueble;
import pe.edu.upc.yourconfort.entities.Universitario;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaDto {
    private Long id_Reserva;
    private LocalDate fecha_Reserva;
    private String comentario;
    private Universitario universitario;
    private InmuebleDto inmueble;
}
