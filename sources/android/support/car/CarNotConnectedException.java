package android.support.car;

public class CarNotConnectedException extends Exception {
    private static final long serialVersionUID = -5629175439268813047L;

    public CarNotConnectedException() {
    }

    public CarNotConnectedException(Exception exc) {
        super(exc);
    }

    public CarNotConnectedException(String str) {
        super(str);
    }

    public CarNotConnectedException(String str, Throwable th) {
        super(str, th);
    }
}
