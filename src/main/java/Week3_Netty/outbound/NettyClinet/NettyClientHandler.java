package Week3_Netty.outbound.NettyClinet;

import Week3_Netty.route.HttpEndPointRouter;
import Week3_Netty.route.RandomHttpEndPointRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(msg.toString());

        DefaultHttpResponse response = (DefaultHttpResponse) msg ;

//        DefaultFullHttpResponse fullResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
//                Unpooled.wrappedBuffer(value.getBytes(StandardCharsets.UTF_8)));
//        response.headers().set("Content-Type", "application/json");
//        response.headers().setInt("Content-Length", response.content().readableBytes());

        ctx.write(response);
    }
}
