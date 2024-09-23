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
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Contrato;
    private LocalDate fecha_Contrato;
    private String comentario;
    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}
