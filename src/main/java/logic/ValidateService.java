package logic;

import dateBase.MemoryStore;
import dateBase.Store;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateService {
    private List<User> userList = new CopyOnWriteArrayList<>();
    private static ValidateService instance;
    private final Store store=MemoryStore.getInstance();
    public static synchronized ValidateService getInstance() {
        if (instance == null) {
            instance = new ValidateService();
        }
        return instance;
    }
    public void add(User user) {
    store.add(user);
    }

    public void update(User user) {
    store.update(user);
    }

    public void delete(User user) {
    store.delete(user);
    }


    public Set<User> findAll() {
        return store.findAll();
    }

    public User findById(int id) {
        return null;
    }
}
