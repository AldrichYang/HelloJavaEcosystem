package network.datagramSocket.single;

import java.io.IOException;

/**
 * Created by yh on 2018/5/17.
 */
public class QuoteServer {
    public static void main(String[] args) throws IOException {
        new QuoteServerThread().start();
    }
}
