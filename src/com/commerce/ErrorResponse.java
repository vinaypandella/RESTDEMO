package com.commerce;



import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public final class ErrorResponse {
    private final String error;

    private ErrorResponse(String error){
        this.error=error;
    }

    public static ErrorResponse error(String message){
        return new ErrorResponse(message);
    }

    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    public String getError() {
        return error;
    }
}
