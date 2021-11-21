package Week3_Netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    void filter (FullHttpResponse response);
}
