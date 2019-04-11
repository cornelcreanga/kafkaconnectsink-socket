package com.ccreanga.kafkaconnectsinksocket.gateways;

import com.ccreanga.kafkaconnectsinksocket.model.Customer;

import java.util.Set;

public interface CustomerStorageInterface {

    void addSocket(Customer customer);
    void removeSocket(Customer customer);
    Set<Customer> getSockets();

}
