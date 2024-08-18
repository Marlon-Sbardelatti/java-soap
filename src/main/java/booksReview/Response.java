package booksReview;

public class Response {
    private boolean success;
    private String message;

    public Response(boolean success, String message) {
        setSuccess(success);
        setMessage(message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.isEmpty() || message == null) {
            throw new IllegalArgumentException("Mensagem não pode ser vazia ou nula");
        }
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\n" +
                " \"success\": " + success + ",\n" +
                " \"message\": \"" + message + "\"\n" +
                "}";
    }
}
