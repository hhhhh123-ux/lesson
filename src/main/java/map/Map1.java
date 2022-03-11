package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map1 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<Integer,String>();

        map.put(1,"1");
        map.put(2,"2");
        map.put(null,"null");


        System.out.println(map);
        map.get(null);
        map.get(1);
        map.get(2);
        System.out.println(map.get(null)+""+map.get(1)+""+map.get(2));
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.print("while="+next.getKey());
            System.out.print("while="+next.getValue());
        }
        map.forEach((key, value) ->{
            System.out.print("foreach="+key);
            System.out.print("foreach="+value);
        });

    }
}
