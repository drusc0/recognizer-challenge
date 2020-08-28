package com.recognizer.concurrent;


import java.util.Objects;

public class Recognizer {
    private static Recognizer instance;
    private final RecognizerModel model;

    private Recognizer(final RecognizerModel model) {
        this.model = model;
    }

    public static Recognizer getInstance(final RecognizerModel model) {
        if (Objects.isNull(instance)) {
            instance = new Recognizer(model);
        }

        return instance;
    }

    public void queueRetrain() {
        Thread newThread = new Thread(new TrainRunnable(this.model));
        newThread.start();
    }

    public void identifyPerson(final PersonInfo info) {
        Runnable runnable = () -> {
            final String name = Thread.currentThread().getName();
            System.out.println("Thread-" + name + " executing now");
            this.model.identifyPerson(info);
            System.out.println("Thread-" + name + " exiting");
        };

        Thread newThread = new Thread(runnable);
        newThread.start();
    }
}
