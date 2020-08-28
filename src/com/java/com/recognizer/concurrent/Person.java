package com.recognizer.concurrent;

import lombok.Builder;

import java.util.UUID;

@Builder
public class Person {
    private final UUID uuid;
    private final PersonInfo personInfo;
}
