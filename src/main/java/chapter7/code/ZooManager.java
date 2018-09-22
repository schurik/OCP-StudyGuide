package chapter7.code;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {

    private Map<String, Object> foodMap = new ConcurrentHashMap<>();

    public void put(final String key, final Object value) {
        foodMap.put(key, value);
    }

    public Object get(final String key) {
        return foodMap.get(key);
    }
}
