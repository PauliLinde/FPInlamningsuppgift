import com.mongodb.Function;

import java.util.Map;
import java.util.stream.Stream;

public interface ActorSearcher {
    Object getActors(Stream<Map.Entry<String, Long>> stream);
}
