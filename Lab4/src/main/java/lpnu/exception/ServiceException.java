package lpnu.exception;

public class ServiceException extends RuntimeException{
    private int code;
    private String message;

    public ServiceException(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(final String message, final Throwable cause, final int code) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
