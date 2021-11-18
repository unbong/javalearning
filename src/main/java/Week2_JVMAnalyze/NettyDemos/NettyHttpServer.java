package Week2_JVMAnalyze.NettyDemos;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyHttpServer {

    public static void main(String[] args)  {

        EventLoopGroup bossEventGroup = new NioEventLoopGroup(2);
        EventLoopGroup wokerEventGroup = new NioEventLoopGroup(16);

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_RCVBUF, 32*1024)
                .childOption(ChannelOption.SO_SNDBUF, 32*1024)
                .childOption(EpollChannelOption.SO_REUSEPORT, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        serverBootstrap.group(bossEventGroup, wokerEventGroup).channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new HttpInitializer());
        try {
            Channel cg = serverBootstrap.bind(8084).sync().channel();
            System.out.println("开启Netty HTTP服务器，监听地址和端口 localhost:"+ 8084);

            cg.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bossEventGroup.shutdownGracefully();
            wokerEventGroup.shutdownGracefully();
        }


    }
}
