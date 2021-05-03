package com.projectsByAman.weatherUpdates.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No such element found!")
public class InputNotFoundException extends RuntimeException {

}