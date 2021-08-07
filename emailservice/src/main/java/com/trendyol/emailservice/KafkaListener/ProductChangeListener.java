package com.trendyol.emailservice.KafkaListener;


import com.trendyol.emailservice.EmailConfig.EmailSenderService;
import com.trendyol.emailservice.model.Customer;
import com.trendyol.emailservice.Service.CustomerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductChangeListener {

    private final CustomerService customerService;

    private final EmailSenderService emailSenderService;


    public ProductChangeListener(CustomerService customerService, EmailSenderService emailSenderService) {
        this.customerService = customerService;

        this.emailSenderService = emailSenderService;
    }
    @KafkaListener(topics = "${kafka.topic.productPriceChange}", groupId = "${kafka.groupId}")
    public void productPriceChangeListener(@Payload String barcode) {

        List<Customer> allCustomerList = customerService.findCustomersBasketWithProductId(barcode);

        allCustomerList.stream().forEach(Customer -> {
            emailSenderService.sendSimpleEmail(Customer.getEmail()," Product :" + barcode + " Price has changed.","Product - Price Change Alert");
            System.out.println("Customer : " + Customer.getName() + " -> Product : " + barcode + "has changed");
        });
    }
    @KafkaListener(topics="${kafka.topic.productStockAlert}", groupId = "${kafka.groupId}")
    public void productStockAlertListener(@Payload String barcode) {

    List<Customer> allCustomerList = customerService.findCustomersBasketWithProductId(barcode);

        allCustomerList.stream().forEach(Customer -> {

        emailSenderService.sendSimpleEmail(Customer.getEmail()," Product :" + barcode + " Stock is less than 3!","Product - Stock  Alert");
        System.out.println("Customer : " + Customer.getName() + " -> Product : " + barcode + " Stock Alert ");
        });
    }
    @KafkaListener(topics="${kafka.topic.productOutOfStock}", groupId = "${kafka.groupId}")
    public void productOutOfStockListener(@Payload String barcode) {

        List<Customer> allCustomerList = customerService.findCustomersBasketWithProductId(barcode);

        allCustomerList.stream().forEach(Customer -> {

            emailSenderService.sendSimpleEmail(Customer.getEmail(), " Product :" + barcode + " is out of Stock!", "Product - Out of Stock ");
            System.out.println("Customer : " + Customer.getName() + " -> Product : " + barcode + " Out of Stock");
        });
    }
}
