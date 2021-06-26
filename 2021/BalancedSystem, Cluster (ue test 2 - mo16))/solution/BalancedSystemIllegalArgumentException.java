import java.io.IOException;

public class BalancedSystemIllegalArgumentException extends IOException {
    private String errorMessage;

    public BalancedSystemIllegalArgumentException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}
