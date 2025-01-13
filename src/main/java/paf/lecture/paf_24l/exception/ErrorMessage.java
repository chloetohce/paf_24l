package paf.lecture.paf_24l.exception;

import java.util.Date;

/*
 * An error message should ideally have: a status code, an error message, a timestamp indicating when the error ocurred, 
 * and the endpoint where it occurred.
 */
public class ErrorMessage {
    private int status;

    private String message;

    private Date timeStamp;
    
    private String endpoint;

    public ErrorMessage() {
    }

    public ErrorMessage(int status, String message, Date timeStamp, String endpoint) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.endpoint = endpoint;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    
}
