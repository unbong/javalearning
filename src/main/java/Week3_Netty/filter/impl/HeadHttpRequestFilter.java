package Week3_Netty.filter.impl;

import Week3_Netty.filter.HttpRequestFilter;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 *
 * 3.（必做）实现过滤器。
 * 再请求头中添加xjava
 *
 */
public class HeadHttpRequestFilter implements HttpRequestFilter {


    @Override
    public void filter(FullHttpRequest request) {
        request.headers().set("xjava", "unbong");
    }
}
