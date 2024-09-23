package pe.edu.upc.yourconfort.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.yourconfort.entities.Inmueble;
import pe.edu.upc.yourconfort.entities.Universitario;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComentarioDto {
    private Long id_Comentario;
    private String contenido;
    private int calificacion;
    private LocalDate fecha;
    private Universitario universitario;
    private InmuebleDto inmueble;
}
