package com.trendyol.emailservice.Repo;


import com.trendyol.emailservice.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer, Integer> {
    Customer findById(String id);

    // CUSTOMER DB'sinde Her customerin bir basket'i var bu basket basketItem adı
        // altında bir Map içeriyor Mapte Productlar var.Query ile
        // verilen Strind id ile product id lere erişmek istiyoruz./

    //Ulaşmak istenilen liste : Verilen Product id'sini basket'lerinde bulunduran Customerlar)
    @Query("#{n1ql.selectEntity} WHERE ANY b In") //EKSIK
    List<Customer> reachCustomerWithProductId(String id);
}
