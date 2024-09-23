package pe.edu.upc.yourconfort.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.yourconfort.entities.Inmueble;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArrendadorDto {
    private Long id_Arrendador;
    private Long dni_Arrendador;
    private String nombre_Arrendador;
    private String telefono_Arrendador;
    private String email_Arrendador;
}
