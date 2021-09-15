package Main;

import java.util.Random;

public class Tester {
    TCPQueue q;

    public Tester(TCPQueue q) {
        this.q = q;
        test();
    }

    public void test() {
        System.out.println("test is now running");
        for (int i = 0; i < 10; i++) {
            q.add("12345");
        }
    }
}
