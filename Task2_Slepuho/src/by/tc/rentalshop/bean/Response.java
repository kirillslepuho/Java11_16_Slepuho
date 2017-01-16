package by.tc.rentalshop.bean;

public class Response {
    private String errorMessage;
    private boolean errorStatus;
    private String message;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {

        return errorMessage;
    }

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public String getMessage() {
        return message;
    }
    
    
    
}
