package com.example.joem.extendinglistviewarrayadapter;

/**
 * Created by JoeM on 10/21/2017.
 */

public class Email {//class to hold email parameter
    String subject, summary, sender;

    //constructor
    public Email(String subject, String summary, String sender) {
        this.subject = subject;
        this.summary = summary;
        this.sender = sender;
    }
}
