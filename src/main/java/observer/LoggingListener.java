package observer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;

public class LoggingListener implements Subscriber {
    private final File log;

    public LoggingListener(String filename) {
        log = new File(filename);
    }

    @Override
    public void update() {
        try {
            String message = LocalDateTime.now() + "file opened";
            Files.write(log.toPath(), message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ignored) {

        }
    }
}
