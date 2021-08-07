package com.trendyol.emailservice.Service;



import com.trendyol.emailservice.Repo.CustomerRepo;
import com.trendyol.emailservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> findCustomersBasketWithProductId(String id){

        return customerRepo.reachCustomerWithProductId(id);
    }

}
