package pe.edu.upc.yourconfort.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Reserva;
    private LocalDate fecha_Reserva;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "universitario_id")
    private Universitario universitario;
    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

}
