package cl.mobdev.dogceoy2k.common;

import java.util.Date;
import java.util.List;

public class MyError {
    private int statusCode;
    private Date timeStamp;
    private List<String> messager;
    private String description;

    public MyError(int statusCode, Date timeStamp, List<String> messager, String description) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.messager = messager;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public List<String> getMessager() {
        return messager;
    }

    public String getDescription() {
        return description;
    }
}
