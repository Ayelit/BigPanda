import data.Cache;
import data.Consumer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("*** MAIN");

        Consumer consumer = new Consumer(new Cache());
        consumer.consume();
    }
}
