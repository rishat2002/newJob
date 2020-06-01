package dateBase;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryStore implements Store {
    private static MemoryStore instance;

    public static synchronized MemoryStore getInstance() {
        if (instance == null) {
            instance = new MemoryStore();
        }
        return instance;
    }
    private final SessionFactory factory=new Configuration().configure().buildSessionFactory();

    @Override
    public void add(User user) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(User user) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
        }
    }


    @Override
    public Set<User> findAll() {
        String sql = "From " + User.class.getSimpleName();
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            List<User> list=session.createQuery(sql).list();

            session.getTransaction().commit();
            return new HashSet<>(list);
        }
    }
    @Override
    public User findById(int id) {
        return null;
    }

    public static void main(String[] args) {

    }
}
