package com.ccreanga.kafkaconnectsinksocket;

import com.ccreanga.kafkaconnectsinksocket.gateways.CustomerStorageInterface;
import com.ccreanga.kafkaconnectsinksocket.model.Customer;
import com.ccreanga.kafkaconnectsinksocket.model.CustomerSocket;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SocketSinkTask extends SinkTask {

    @Autowired
    private CustomerStorageInterface customerStorageInterface;

    private Set<CustomerSocket> customerSockets;

    @Override
    public String version() {
        return "0.1";
    }

    @Override
    public void start(Map<String, String> props) {
    }

    @Override
    public void put(Collection<SinkRecord> records) {
        for (final SinkRecord record : records) {

            Message message = (Message)record.value();
            Set<Customer> customers = customerStorageInterface.getSockets();

        }
    }

    @Override
    public void stop() {

    }
}
