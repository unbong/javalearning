package Week3_Netty.outbound.okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * OkHttp的方式发送请求，但是无法连接到服务器，原因日后在调查，
 * O
 */

public class OKHttpOutboundHandler {

     private List<String> proxyServer ;
     public OKHttpOutboundHandler( List<String> proxyServer)
     {
         this.proxyServer = proxyServer.stream().map(s ->
                    { return s.endsWith("/")?s.substring(0, s.length()-1):s ;}).collect(Collectors.toList());

     }


     public void handler(ChannelHandlerContext ctx, FullHttpRequest request) throws IOException {

        System.out.println("okhttp handler start");
         // todo  先使用固定的访问地址
         String url = proxyServer.get(0) + request.uri();


         System.out.println("url: " + url   );

         Request okHttpRequest = new Request.Builder()
                 .url(url)
                 .get()
                 .build();

         OkHttpClient client = new OkHttpClient();
         client.setRetryOnConnectionFailure(true);
         Response responses = client.newCall(okHttpRequest).execute();

         String s = responses.body().toString();

         System.out.println("response: " + s   );
     }
}
