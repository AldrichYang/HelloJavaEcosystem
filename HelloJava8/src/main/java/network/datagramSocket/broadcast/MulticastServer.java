package network.datagramSocket.broadcast;

/**
 * Created by yh on 2018/5/17.
 */
public class MulticastServer {
    public static void main(String[] args) throws java.io.IOException {
        new MulticastServerThread().start();
    }
}
