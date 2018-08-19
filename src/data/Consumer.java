package data;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer {
    static BlockingQueue<String> queue = new LinkedBlockingDeque<>();
    private Cache cache;

    public Consumer(Cache cache) {
        this.cache = cache;
    }

    public void consume() throws IOException {
        Process process = new ProcessBuilder("/Users/ayeletliberman/Ayelet/AyeletBigPanda/generator-macosx-amd64").start();

        InputStream processInputStream = process.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(processInputStream));

        Thread t = new Thread(() -> {
            try {
                for (String line; (line = reader.readLine()) != null;) {
                    queue.put(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t.start();
        for (;;) {
            String line = queue.poll();
            if (line != null) {
                this.cache.add(line);
            } else if (!t.isAlive()) {
                break;
            }
        }
    }
}
