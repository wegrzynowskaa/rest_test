package pl.test.service;

import org.springframework.stereotype.Service;
import pl.test.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();
    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    @Override
    public User findById(final long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(final String name) {
        for (User user : users) {
            if (name.equalsIgnoreCase(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(final User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    @Override
    public void updateUser(final User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(final long id) {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }

    @Override
    public boolean isUserExist(final User user) {
        return findByName(user.getUserName()) != null;
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(counter.incrementAndGet(), "user1", "Sam", "Smith", "sam@abc.com"));
        users.add(new User(counter.incrementAndGet(), "star", "Tomy", "Albama", "tomy@abc.com"));
        users.add(new User(counter.incrementAndGet(), "bossy", "Kelly", "Familly", "kelly@abc.com"));
        return users;
    }
}
