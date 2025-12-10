package net.yasmine.microservices.billing.controller;

import net.yasmine.microservices.billing.entity.Bill;
import net.yasmine.microservices.billing.entity.BillStatus;
import net.yasmine.microservices.billing.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Bill REST Controller - Yasmine's Billing Service
 */
@RestController
@RequestMapping("/api/billing")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return ResponseEntity.status(HttpStatus.CREATED).body(billService.createBill(bill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return billService.getBillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Bill>> getBillsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(billService.getBillsByCustomerId(customerId));
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Bill> updateBillStatus(@PathVariable Long id, @RequestParam BillStatus status) {
        return ResponseEntity.ok(billService.updateBillStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
