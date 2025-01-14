package Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Repository<T> {
    private final Map<Integer, T> store = new HashMap<>();
    private int currentId = 1;

    public int create(T entity) {
        store.put(currentId, entity);
        return currentId++;
    }

    public Optional<T> read(int id) {
        return Optional.ofNullable(store.get(id));
    }

    public boolean update(int id, T updatedEntity) {
        if (store.containsKey(id)) {
            store.put(id, updatedEntity);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return store.remove(id) != null;
    }

    public List<T> readAll() {
        return new ArrayList<>(store.values());
    }
}
