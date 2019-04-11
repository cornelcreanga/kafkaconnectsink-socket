package com.ccreanga.kafkaconnectsinksocket.model;

import lombok.Value;

import java.util.Set;

@Value
public class Customer {

    private String name;
    private String host;
    private int port;
    private Set<Long> matches;

}
