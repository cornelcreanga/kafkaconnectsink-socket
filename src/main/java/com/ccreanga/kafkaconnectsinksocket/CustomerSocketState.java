package com.ccreanga.kafkaconnectsinksocket;

import com.ccreanga.kafkaconnectsinksocket.model.Customer;
import com.ccreanga.kafkaconnectsinksocket.model.CustomerSocket;

import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomerSocketState {

    private ConcurrentSkipListSet<CustomerSocket> customerSockets = new ConcurrentSkipListSet<>();
    private ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(128);

    public void newCustomerRegistration(Customer customer){
        Socket socket = null;
        try{
            socket = new Socket(customer.getHost(),Integer.parseInt(customer.getName()));
        }catch (IOException e){
            e.printStackTrace();
        }
        customerSockets.add(new CustomerSocket(socket,-1,customer));
    }

    public Set<CustomerSocket> getCustomerSockets(){
        return Collections.unmodifiableSet(customerSockets);
    }

}
