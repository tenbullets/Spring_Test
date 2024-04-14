package ru.itis.spring_test.services;

public interface SmsService {
    void sendSms(String phone, String text);
}
