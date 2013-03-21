package com.commerce;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import static com.commerce.ErrorResponse.error;

@Component
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ErrorResponse cantFindTheRecord(final RecordNotFoundException exception) {
        return error(NOT_FOUND.toString());
    }

    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse someThingWentWrong(Exception exception) {
        return error(INTERNAL_SERVER_ERROR.toString());
    }
}
