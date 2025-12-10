package net.yasmine.microservices.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Billing Service Application - Yasmine Microservices
 * Manages all billing and invoice operations
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
}
