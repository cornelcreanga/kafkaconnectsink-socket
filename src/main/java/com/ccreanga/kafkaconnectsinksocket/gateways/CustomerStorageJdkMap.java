package com.ccreanga.kafkaconnectsinksocket.gateways;

import com.ccreanga.kafkaconnectsinksocket.model.Customer;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class CustomerStorageJdkMap implements CustomerStorageInterface {

    private ConcurrentSkipListSet<Customer> set = new ConcurrentSkipListSet<>();

    @Override
    public void addSocket(Customer customer) {
        set.add(customer);
    }

    @Override
    public void removeSocket(Customer customer) {
        set.remove(customer);
    }

    @Override
    public Set<Customer> getSockets() {
        return Collections.unmodifiableSet(set);
    }
}
