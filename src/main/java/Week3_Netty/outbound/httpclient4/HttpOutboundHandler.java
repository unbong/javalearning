package Week3_Netty.outbound.httpclient4;

import Week3_Netty.filter.HttpRequestFilter;
import Week3_Netty.filter.impl.HeadHttpRequestFilter;
import Week3_Netty.route.HttpEndPointRouter;
import Week3_Netty.route.RandomHttpEndPointRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import javax.swing.plaf.synth.SynthUI;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 *   作业 1 （必做）整合你上次作业的 httpclient/okhttp。
 *
 *
 *
 *
 */
public class HttpOutboundHandler  {

    private List<String> proxyServer ;
    private HttpEndPointRouter router;
    private HttpRequestFilter filter;


    public HttpOutboundHandler(List<String> proxyServer)
    {
        this.proxyServer = proxyServer.stream().map(s ->
        { return s.endsWith("/")?s.substring(0, s.length()-1):s ;}).collect(Collectors.toList());
        router = new RandomHttpEndPointRouter();
        filter = new HeadHttpRequestFilter();
    }

    /**
     *
     * 请求的处理器 通过httpclient的方式，对后台服务器发送请求
     *
     * @param ctx
     * @param request
     */
    public void handler(ChannelHandlerContext ctx , FullHttpRequest request )  {
        System.out.println("http client handler start");

        // 通过随机路由获取访问路径
        String routeUrl =  router.route(this.proxyServer);
        // 执行过滤器方法
        filter.filter(request);
        String url = routeUrl + request.uri();
        // 利用HTTPClient方法，访问后台服务。
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        FullHttpResponse fullHttpResponse = null;
        HttpResponse httpResponse = null;

        try {
            httpResponse = client.execute(httpGet);
            HttpEntity httpEntity =  httpResponse.getEntity();
            if(httpEntity != null)
            {
                // 从后台获取到数据后，将数据返回给网关调用者。
                byte[] bytes = EntityUtils.toByteArray( httpEntity);
                String s = new String(bytes);
                System.out.println("response: " + s);
                fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK
                        , Unpooled.wrappedBuffer(bytes));
                fullHttpResponse.headers().set("Content-Type", "Application/json");
                fullHttpResponse.headers().set("Content-length", bytes.length);
                ctx.write(fullHttpResponse);
                //ctx.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();

            fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
            ctx.close();
        }
        finally {
            if(request != null)
            {
                if(HttpUtil.isKeepAlive(request)){
                    ctx.write(fullHttpResponse).addListener(ChannelFutureListener.CLOSE);
                }else{
                    fullHttpResponse.headers().set("Connecion", "keep-alive");
                    ctx.write(fullHttpResponse);

                }
            }
            ctx.flush();
        }
    }
}
