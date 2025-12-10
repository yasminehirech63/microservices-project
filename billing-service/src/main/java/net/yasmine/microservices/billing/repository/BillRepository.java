package net.yasmine.microservices.billing.repository;

import net.yasmine.microservices.billing.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Bill Repository - Yasmine's Billing Service
 */
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomerId(Long customerId);
}
