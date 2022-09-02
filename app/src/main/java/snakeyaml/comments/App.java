package snakeyaml.comments;

import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.api.StreamDataWriter;
import org.snakeyaml.engine.v2.comments.CommentType;
import org.snakeyaml.engine.v2.emitter.Emitter;
import org.snakeyaml.engine.v2.events.*;

import java.io.StringWriter;
import java.util.Optional;

import static java.util.Collections.emptyMap;

public class App {
    public static void main(String[] args) {
        DumpSettings settings = DumpSettings.builder().build();
        StreamDataWriter writer = new StreamToStringWriter();
        Emitter emitter = new Emitter(settings, writer);
        emitter.emit(new StreamStartEvent());
        emitter.emit(new DocumentStartEvent(false, Optional.empty(), emptyMap()));
        emitter.emit(new CommentEvent(CommentType.BLOCK, "Hello world!", Optional.empty(), Optional.empty()));
        emitter.emit(new DocumentEndEvent(false));
        emitter.emit(new StreamEndEvent());

        System.out.println("YAML:");
        System.out.println(writer.toString());
    }
}

class StreamToStringWriter extends StringWriter implements StreamDataWriter {
}
