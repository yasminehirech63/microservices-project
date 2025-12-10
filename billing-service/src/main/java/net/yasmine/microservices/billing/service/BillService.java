package net.yasmine.microservices.billing.service;

import net.yasmine.microservices.billing.entity.Bill;
import net.yasmine.microservices.billing.entity.BillStatus;
import net.yasmine.microservices.billing.repository.BillRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Bill Service - Business logic for billing operations by Yasmine
 */
@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill createBill(Bill bill) {
        bill.setStatus(BillStatus.PENDING);
        return billRepository.save(bill);
    }

    public Optional<Bill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    public List<Bill> getBillsByCustomerId(Long customerId) {
        return billRepository.findByCustomerId(customerId);
    }

    public Bill updateBillStatus(Long id, BillStatus status) {
        return billRepository.findById(id)
                .map(bill -> {
                    bill.setStatus(status);
                    return billRepository.save(bill);
                })
                .orElseThrow(() -> new RuntimeException("Bill not found"));
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
