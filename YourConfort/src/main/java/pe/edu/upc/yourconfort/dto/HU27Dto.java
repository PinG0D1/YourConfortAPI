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
public class HU27Dto {
    private Long id_Contrato;
    private String nombreUniversitario;
    private String emailUniversitario;
    private String telefonoUniversitario;
    private LocalDate fechaContrato;
}
