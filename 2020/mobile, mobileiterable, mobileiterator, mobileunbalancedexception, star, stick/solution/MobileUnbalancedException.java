public class MobileUnbalancedException extends Exception {
    private String cause;

    public MobileUnbalancedException(String message) {
        cause = message;
    }

    @Override
    public String getMessage() {
        return cause;
    }
}
