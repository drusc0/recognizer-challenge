package com.recognizer.concurrent;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RecognizerModel {
    private ReentrantReadWriteLock lock;
    private final Lock readLock;
    private final Lock writeLock;

    public RecognizerModel() {
        this.lock = new ReentrantReadWriteLock();
        this.readLock = this.lock.readLock();
        this.writeLock = this.lock.writeLock();
    }

    public void trainWithLatestData() {
        this.writeLock.lock();
        try {
            System.out.println("Trainig Model with the Latest Data"); }
        finally { this.writeLock.unlock(); }
    }

    public Person identifyPerson(final PersonInfo info) {
        this.readLock.lock();
        try {
            final Person person = Person.builder()
                    .personInfo(PersonInfo.builder()
                            .firstName("Andres")
                            .lastName("Rivero")
                            .build())
                    .uuid(UUID.randomUUID())
                    .build();
            System.out.println("Fetching Person Info: " + person.toString());
            return person;
        } finally {
            this.readLock.unlock();
        }
    }
}
