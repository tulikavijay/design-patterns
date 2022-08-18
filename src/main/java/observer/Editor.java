package observer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Editor {
    private String filename;
    private File file;
    private EventManager eventManager;

    public Editor(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void openFile() {
        file = new File(filename);
        eventManager.notify(EventType.OPEN);
    }

    public void saveFile(String updatedText) throws IOException {
        Files.write(Paths.get(filename), updatedText.getBytes(StandardCharsets.UTF_8));
        eventManager.notify(EventType.SAVE);
    }
}
