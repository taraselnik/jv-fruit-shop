package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, String> storage = new HashMap<>();

    @Override
    public boolean update(String fruit, String quantity) {
        return storage.put(fruit, quantity) != null;
    }

    @Override
    public Map<String, String> getAll() {
        return storage;
    }
}
