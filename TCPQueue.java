package Main;

import java.util.ArrayList;

public class TCPQueue {
    private ArrayList<String> q;

    public TCPQueue() {
        q = new ArrayList<String>();
    }

    public void add(String in) {
        q.add(in);
    }

    public String get() {
        if (q.size() > 0) {
            String returnValue = q.get(0);
            q.remove(0);
            return returnValue;
        }
        return null;
    }

    public int size() {
        return q.size();
    }
}
