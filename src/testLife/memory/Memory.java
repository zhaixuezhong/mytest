package testLife.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaixuezhong on 11/23/16.
 */
public class Memory {
    static class OOMObject {}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
            }
        }

}
