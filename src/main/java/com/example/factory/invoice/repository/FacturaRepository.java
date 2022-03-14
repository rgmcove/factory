package com.example.factory.invoice.repository;

import com.example.factory.invoice.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}