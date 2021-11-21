package Week3_Netty.route;

import java.util.List;

public interface HttpEndPointRouter {

    String route(List<String> urls);
}
