package dateBase;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Exp {
    public static void main(String[] args) {
        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            MemoryStore mem=new MemoryStore();
            User user=new User();
            user.setName("Polina");
            user.setLogin("Reen");
            user.setEmail("miki.com");
            user.setDate(new Date().toString());
            mem.add(user);
            mem.add(user);
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
