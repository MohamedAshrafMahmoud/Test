package com.example.test.Model;

/**
 * Created by emad on 2/4/19.
 */

public class Question {
    int id;
    String question;
    String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
