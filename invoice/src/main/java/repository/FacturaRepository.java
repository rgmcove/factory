package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}