package Week6_Mysql.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class CollectionDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4,2,3,5,1,2,2,7,6);

        Collections.sort(list);
        log.info(list.toString());

        Collections.reverse(list);
        log.info(list.toString());

        Collections.shuffle(list);
        log.info(list.toString());

        System.out.println(Collections.frequency(list,2));

        Collections.fill(list,8);
        log.info(list.toString());


    }
}
