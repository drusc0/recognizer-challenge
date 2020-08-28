package com.recognizer.concurrent;

public class Main {
    public static void main(String[] args) {
	// write your code here
        final RecognizerModel model = new RecognizerModel();
        final Recognizer recognizer = Recognizer.getInstance(model);

        // First time training modle
        model.trainWithLatestData();

        // see what the response is.
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.queueRetrain();
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.queueRetrain();
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
        recognizer.identifyPerson(PersonInfo.builder().build());
    }
}
