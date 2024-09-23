package pe.edu.upc.yourconfort.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.yourconfort.entities.Reserva;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContratoDto {
    private Long id_Contrato;
    private LocalDate fecha_Contrato;
    private String comentario;
    private ReservaDto reserva;
}
