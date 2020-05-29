package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by yh on 2018/5/14.
 */
public class ReadURL {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://www.baidu.com/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
