package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.yourconfort.entities.Universidad;

public interface UniversidadRepository extends JpaRepository<Universidad, Long> {
}
