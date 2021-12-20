package com.examapp.model;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrors {

    LocalDateTime timeStamp;
    HttpStatus status;
    String message;
    String path;

}
