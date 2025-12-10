package net.yasmine.microservices.inventory.repository;

import net.yasmine.microservices.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Product Repository - Yasmine's Inventory Service
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}
