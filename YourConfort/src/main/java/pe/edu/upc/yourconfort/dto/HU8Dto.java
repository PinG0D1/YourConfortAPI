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
public class HU8Dto {
    private Long id_Comentario;
    private String contenido;
    private int calificacion;
    private LocalDate fecha;
    private String nombreUniversitario;
}
