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
public class Universitario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Universitario;
    private Long dni_Universitario;
    private String nombre_Universitario;
    private String email_Universitario;
    private String telefono_Universitario;
}
