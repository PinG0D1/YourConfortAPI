package pe.edu.upc.yourconfort.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.yourconfort.entities.Arrendador;
import pe.edu.upc.yourconfort.entities.Comentario;
import pe.edu.upc.yourconfort.entities.Reserva;
import pe.edu.upc.yourconfort.entities.Universidad;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InmuebleDto {
    private Long id_Inmueble;
    private String direccion_Inmueble;
    private String tipo_Inmueble;
    private float precio_Inmueble;
    private String descripcion_Propiedad;
    private String estado_Propiedad;
    private Arrendador arrendador;
    private Universidad universidad;
    private LocalDate fechaPublicacion;
}
