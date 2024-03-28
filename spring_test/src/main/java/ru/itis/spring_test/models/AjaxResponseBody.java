package ru.itis.spring_test.models;

import java.util.Optional;

public class AjaxResponseBody {

    String msg;
    Optional<User> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Optional<User> getResult() {
        return result;
    }

    public void setResult(Optional<User> result) { this.result = result; }

}
