package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * ss
 */
public class MemoryEater {

    public static void main(String[] args) {

        List<Element> list = new ArrayList<>(10000);

        while (true) {
            list.add(new Element());
            System.out.println(list.size());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Element {
        private byte[] buf;

        public Element() {
            this.buf = new byte[1024 * 1024];
        }
    }
}
