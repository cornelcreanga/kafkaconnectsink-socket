package com.ccreanga.kafkaconnectsinksocket;

import com.ccreanga.kafkaconnectsinksocket.gateways.CustomerStorageInterface;
import com.ccreanga.kafkaconnectsinksocket.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RegisterController {

    @Autowired
    private CustomerSocketState customerSocketState;

    @Autowired
    private CustomerStorageInterface customerStorageInterface;

    @GetMapping("/register")
    public void register(
            @RequestParam(name="name") String name,
            @RequestParam(name="host") String host,
            @RequestParam(name="port") String port,
            @RequestParam(name="port") List<String> matches,

            Model model) {

        Set<Long> m = matches.stream().map(Long::parseLong).collect(Collectors.toSet());
        Customer customer = new Customer(name,host,Integer.parseInt(port),m);
        customerStorageInterface.addSocket(customer);
        customerSocketState.newCustomerRegistration(customer);
    }

}
