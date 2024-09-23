package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.yourconfort.entities.Arrendador;

public interface ArrendadorRepository extends JpaRepository<Arrendador, Long> {
}
