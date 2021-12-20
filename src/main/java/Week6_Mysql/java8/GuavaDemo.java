package Week6_Mysql.java8;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import org.apache.activemq.util.IntSequenceGenerator;

import java.util.List;
import java.util.Map;

public class GuavaDemo {

    static EventBus bus = new EventBus();

    static{
        bus.register(new GuavaDemo());
    }

    public static void main(String[] args) {


    }

    public static void testBiMap(List<String> list)
    {
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("fisrt",1);
        words.put("second",2);

        words.put("thris",1);


        System.out.println(words.get("second").intValue());
        System.out.println(words.inverse().get(1));
        //Map<String, String> map1 = Maps.toMap(list.listIterator(),)


    }
}
