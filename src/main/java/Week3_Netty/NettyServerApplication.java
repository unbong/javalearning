package Week3_Netty;


import Week3_Netty.NettyServer.HttpInboundServer;

import java.util.Arrays;
import java.util.List;

public class NettyServerApplication {

    public static void main(String[] args) {
        String proxyPort = "8881";
        String proxyServers = System.getProperty("proxyServers","http://localhost:8081,http://localhost:8082");
        int port = Integer.parseInt(proxyPort);
        List<String> proxyServer =  Arrays.asList(proxyServers.split(","));
        HttpInboundServer server = new HttpInboundServer(port, proxyServer);
        try {
            server.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
