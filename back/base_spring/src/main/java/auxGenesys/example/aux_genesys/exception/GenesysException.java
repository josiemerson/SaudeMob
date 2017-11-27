package auxGenesys.example.aux_genesys.exception;

public class GenesysException extends Exception {
    public static String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
