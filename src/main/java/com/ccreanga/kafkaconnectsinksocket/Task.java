package com.ccreanga.kafkaconnectsinksocket;

public class Task implements Runnable {
    private String name;

    public Task(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }