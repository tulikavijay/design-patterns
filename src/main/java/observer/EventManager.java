package observer;

import java.util.HashMap;
import java.util.HashSet;

public class EventManager {
    HashMap<EventType, HashSet<Subscriber>> subscribers;

    public EventManager() {
        this.subscribers = new HashMap<>();
        subscribers.put(EventType.OPEN, new HashSet<>());
        subscribers.put(EventType.SAVE, new HashSet<>());
    }

    public void notify(EventType eventType) {
        for (Subscriber subscriber : subscribers.get(eventType))
            subscriber.update();
    }

    public void subscribe(Subscriber subscriber, EventType eventType) {
        this.subscribers.get(eventType).add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber, EventType eventType) {
        this.subscribers.get(eventType).remove(subscriber);
    }
}
