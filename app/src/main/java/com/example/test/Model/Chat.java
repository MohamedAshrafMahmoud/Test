package com.example.test.Model;

public class Chat {

    private String sender;
    private String receiver;
    private String message;
    private int flag=1;

    public Chat(String sender, String receiver, String message  ) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
      }

    public Chat() {
    }

    public Chat(String message, int flag) {
        this.message = message;
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }



    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
