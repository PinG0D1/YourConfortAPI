package pe.edu.upc.yourconfort.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Inmueble;
    private String direccion_Inmueble;
    private String tipo_Inmueble;
    private float precio_Inmueble;
    private String descripcion_Propiedad;
    private String estado_Propiedad;
    private LocalDate fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "arrendador_id")
    private Arrendador arrendador;

    @ManyToOne
    @JoinColumn(name = "universidad_id")
    private Universidad universidad;
    @OneToMany(mappedBy = "inmueble")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "inmueble")
    private List<Reserva> reservas;

}
