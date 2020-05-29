package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by yh on 2018/5/15.
 */
public class RWURLFromConnection {
    public static void main(String[] args) {

    }

    public static void readURL() throws IOException {
        URL oracle = new URL("http://www.oracle.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

    public static void writeURL(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage:  java Reverse "
                    + "http://<location of your servlet/script>"
                    + " string_to_reverse");
            System.exit(1);
        }

        String stringToReverse = URLEncoder.encode(args[1], "UTF-8");

        URL url = new URL(args[0]);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

//        If the URL does not support output, getOutputStream method throws an UnknownServiceException.
// If the URL does support output, then this method returns an output stream that is connected to the input stream of the URL on the server side — the client's output is the server's input
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("string=" + stringToReverse);
        out.close();
        // the data written to the output stream on the client side is the input for the servlet on the server side


//      The servlet reads the information you write, performs a reverse operation on the string value, and then sends this back to you.
// You now need to read the string the server has sent back
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();
    }
}
