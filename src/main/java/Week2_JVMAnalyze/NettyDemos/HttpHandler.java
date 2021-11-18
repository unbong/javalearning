package Week2_JVMAnalyze.NettyDemos;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.StandardCharsets;

public class HttpHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){

        FullHttpRequest fullRequst = (FullHttpRequest) msg;

        String uri = fullRequst.uri();

        if(uri.contains("/test")){

            haldler(fullRequst, ctx, "test");
        }

    }

    private void haldler(FullHttpRequest fullRequst, ChannelHandlerContext ctx, String s) {

        FullHttpResponse response = null;
        try{

            String value = "hello, access." + s;

            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(value.getBytes(StandardCharsets.UTF_8)));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());



        }catch (Exception e )
        {
            System.out.println("处理出错:"+ e.getMessage());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        }
        finally {
            if(fullRequst != null)
            {
                if(HttpUtil.isKeepAlive(fullRequst)){
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                }else{
                   response.headers().set("Connecion", "keep-alive");
                    ctx.write(response);

                }


            }
        }


    }
}
