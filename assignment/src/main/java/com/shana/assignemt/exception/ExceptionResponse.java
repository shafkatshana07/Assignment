package com.shana.assignemt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ExceptionResponse extends RuntimeException {

    private Date myTimestamp;
    private String message;
    private String details;

}
