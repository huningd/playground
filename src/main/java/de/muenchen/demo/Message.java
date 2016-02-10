package de.muenchen.demo;

/**
 * Created by dennis_huning on 10.02.16.
 */
public class Message {

    private Integer amount;
    private String message;

    public Message() {

    }

    public Message(Integer amount, String message) {
        this();
        this.amount = amount;
        this.message = message;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "amount=" + amount +
                ", message='" + message + '\'' +
                '}';
    }
}
