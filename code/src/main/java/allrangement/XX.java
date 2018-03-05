package allrangement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUANGYE2 on 1/26/2018.
 */
public class XX {

    public static void main(String[] args) {

        List<String> list = null;

        // Remove by for-each

        list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);

        // Remove by simple loop

//        list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        for (int i = 0; i < list.size(); i++) {
//            if ("2".equals(list.get(i))) {
//                list.remove(i);
//            }
//        }
//
//        System.out.println(list);

    }
}
