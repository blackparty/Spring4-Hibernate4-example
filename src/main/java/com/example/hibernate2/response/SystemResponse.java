package com.example.hibernate2.response;

/**
 * Created by MimiKuchiki on 17/5/2018.
 */
public class SystemResponse {
    private boolean flag;
    private String message;

    public SystemResponse(){


    }

    public SystemResponse(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
