package com.recognizer.concurrent;

public class TrainRunnable implements Runnable {
    private final RecognizerModel model;
    private final String name;

    public TrainRunnable(final RecognizerModel model) {
        this.model = model;
        this.name = Thread.currentThread().getName();
    }

    @Override
    public void run() {
        System.out.println("Thread-" + this.name + " executing now");
        this.model.trainWithLatestData();
        System.out.println("Thread-" + this.name + " exiting");
    }
}
