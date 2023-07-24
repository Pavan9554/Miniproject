package com.myblog.blogapp.payloadorDTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private Date timeStamp;
    private String message;
    private String details;

//    public Date getTimeStamp() {
//        return timeStamp;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//
//    public ErrorDetails(Date timeStamp, String message, String details) {
//        this.timeStamp = timeStamp;
//        this.message = message;
//        this.details = details;
//    }
}
