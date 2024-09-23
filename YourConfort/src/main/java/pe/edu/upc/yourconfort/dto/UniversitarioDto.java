package pe.edu.upc.yourconfort.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.yourconfort.entities.Comentario;
import pe.edu.upc.yourconfort.entities.Reserva;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniversitarioDto {
    private Long id_Universitario;
    private Long dni_Universitario;
    private String nombre_Universitario;
    private String email_Universitario;
    private String telefono_Universitario;
}
