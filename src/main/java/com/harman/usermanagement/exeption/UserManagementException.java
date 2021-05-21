

package com.harman.usermanagement.exeption;


public class UserManagementException extends RuntimeException {

    private int httpStatusCode;
    private String errorMessage;

    public UserManagementException(String errorMessage, int httpStatusCode) {
        super(errorMessage);
        this.httpStatusCode = httpStatusCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
