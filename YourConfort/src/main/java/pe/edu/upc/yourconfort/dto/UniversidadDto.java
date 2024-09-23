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
public class UniversidadDto {
    private Long id_Universidad;
    private String nombre;
    private String sede_Universidad;
}
