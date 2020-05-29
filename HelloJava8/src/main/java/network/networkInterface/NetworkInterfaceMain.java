package network.networkInterface;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;

/**
 * Created by yh on 2018/5/18.
 */
public class NetworkInterfaceMain {
    public static void main(String[] args) throws IOException {

        selectInterfaceToUse();
    }

    private static void selectInterfaceToUse() throws IOException {
//  query the system for the appropriate interfaces and find an address on the interface you want to use.
//  When you create the socket and bind it to that address, the system uses the associated interface
        NetworkInterface nif = NetworkInterface.getByName("bge0");
        Enumeration<InetAddress> nifAddresses = nif.getInetAddresses();
        Socket soc = new Socket();
        InetAddress address = nifAddresses.nextElement();
        soc.bind(new InetSocketAddress(address, 0));
        soc.connect(new InetSocketAddress(InetAddress.getByName("server.ip"), 1122));

//  use NetworkInterface to identify the local interface on which a multicast group is to be joined
        MulticastSocket ms = new MulticastSocket();
        ms.joinGroup(new InetSocketAddress(InetAddress.getByName("server.ip"), 1122), nif);

    }


}
