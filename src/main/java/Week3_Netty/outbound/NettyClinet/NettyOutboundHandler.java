package Week3_Netty.outbound.NettyClinet;



import Week3_Netty.route.HttpEndPointRouter;
import Week3_Netty.route.RandomHttpEndPointRouter;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 *2.（选做）使用 Netty 实现后端 HTTP 访问（代替上一步骤）。
 *
 *
 */
public class NettyOutboundHandler  {

    private List<String> proxyServer ;
    private HttpEndPointRouter router;

    public NettyOutboundHandler(List<String> proxyServer)
    {
        this.proxyServer = proxyServer.stream().map(s ->
        { return s.endsWith("/")?s.substring(0, s.length()-1):s ;}).collect(Collectors.toList());
        router = new RandomHttpEndPointRouter();
    }


//    public static void main(String[] args) {
//        List<String> host = new ArrayList<>();
//        host.add("http://localhost:8081");
//        host.add("http://localhost:8082");
//        NettyOutboundHandler n = new NettyOutboundHandler(host);
//        try {
//            n.handle(null, null);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public void handle () throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap= new Bootstrap();
            bootstrap.group(bossGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new NettyClientChannelInitializer());


            String host = router.route(this.proxyServer).replaceAll("http://", "");

            int coronIndex = host.lastIndexOf(':');
            ChannelFuture future =bootstrap.connect(host.substring(0, coronIndex), Integer.parseInt(host.substring(coronIndex+1))).sync();
           // ChannelFuture future =bootstrap.connect("localhost", Integer.parseInt(host.substring(coronIndex+1))).sync();

            future.channel().closeFuture().sync();
            future.channel().flush();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            bossGroup.shutdownGracefully();
        }

    }
}
