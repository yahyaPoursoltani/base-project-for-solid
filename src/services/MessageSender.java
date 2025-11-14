package services;

public interface MessageSender {
    public void sendEmail(String to, String message);
    public void sendSms(String targetNumber, String message);
}
