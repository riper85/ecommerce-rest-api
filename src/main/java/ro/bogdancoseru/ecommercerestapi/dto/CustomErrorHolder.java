package ro.bogdancoseru.ecommercerestapi.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

public class CustomErrorHolder {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy. HH:mm a z")
    private Date timestamp;
    private String status;
    private String error;
    private String path;

    public CustomErrorHolder(Date timestamp, String error, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.path = path;
    }

    public CustomErrorHolder status(String httpStatus) {
        setStatus(httpStatus);
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}