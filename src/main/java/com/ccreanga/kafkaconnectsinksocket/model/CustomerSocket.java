package com.ccreanga.kafkaconnectsinksocket.model;

import lombok.Value;

import java.net.Socket;

@Value
public class CustomerSocket {

    private Socket socket;
    private long lastPackage;
    private Customer customer;

}
