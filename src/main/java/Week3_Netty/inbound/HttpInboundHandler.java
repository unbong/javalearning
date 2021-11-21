package Week3_Netty.inbound;


import Week3_Netty.filter.HttpRequestFilter;
import Week3_Netty.filter.impl.HeadHttpRequestFilter;
import Week3_Netty.outbound.NettyClinet.NettyClientHandler;
import Week3_Netty.outbound.NettyClinet.NettyOutboundHandler;
import Week3_Netty.outbound.httpclient4.HttpOutboundHandler;
import Week3_Netty.outbound.okhttp.OKHttpOutboundHandler;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

import java.io.IOException;
import java.util.List;

/**
 *
 *
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer ;
    private HttpOutboundHandler outboundHandler;
    private OKHttpOutboundHandler okHttpOutboundHandler;
    private HttpRequestFilter filter = new HeadHttpRequestFilter();
    private NettyOutboundHandler nettyOutboundHandler ;

    public HttpInboundHandler(List<String> proxyServer)
    {
        this.proxyServer = proxyServer;
        this.outboundHandler = new HttpOutboundHandler(this.proxyServer);
        this.okHttpOutboundHandler = new OKHttpOutboundHandler(this.proxyServer);
        this.nettyOutboundHandler = new NettyOutboundHandler(this.proxyServer);


    }
    public void channelReadComplete(ChannelHandlerContext ctx)
    {
        ctx.flush();
    }

    /**
     * 接收到请求之后，利用HTTPClient 或Netty客户端方法，对后台服务进行访问，
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        FullHttpRequest request = (FullHttpRequest) msg;
        //  利用HttpClient发送请求
        //outboundHandler.handler(ctx, request);

        //  Netty 实现后端 HTTP 访问
        //nettyOutboundHandler.handle(ctx, request);
        nettyOutboundHandler.handle();

    }



}
