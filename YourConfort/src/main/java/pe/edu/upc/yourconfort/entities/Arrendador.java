package pe.edu.upc.yourconfort.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Arrendador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Arrendador;
    private Long dni_Arrendador;
    private String nombre_Arrendador;
    private String telefono_Arrendador;
    private String email_Arrendador;
}
