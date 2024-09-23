package pe.edu.upc.yourconfort.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.yourconfort.entities.Universitario;

public interface UniversitarioRepository extends JpaRepository<Universitario, Long> {
}
