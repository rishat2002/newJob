package dateBase;


import model.User;

import java.util.Set;

public interface Store {
public void add(User user);
public void update(User user);
public void delete(User user);
public Set<User> findAll();
public User findById(int id);

}
