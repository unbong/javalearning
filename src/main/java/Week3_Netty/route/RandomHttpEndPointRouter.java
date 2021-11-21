package Week3_Netty.route;

import java.util.List;
import java.util.Random;

public class RandomHttpEndPointRouter implements HttpEndPointRouter {

    /**
     * （选做）实现路由。
     *  随机访问方式的路由
     * @param urls
     * @return
     */
    @Override
    public String route(List<String> urls) {

        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }


}
