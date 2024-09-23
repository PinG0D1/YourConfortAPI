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
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Comentario;
    private String contenido;
    private int calificacion;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "universitario_id")
    private Universitario universitario;

    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;
}
