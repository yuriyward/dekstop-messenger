package zaawjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zaawjava.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final DatabaseConnector databaseConnector;

    @Autowired
    public UserService(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    private HashMap<Integer, User> listOfLoggedUsers = new HashMap<>();

    public void addUserToLoggedList(User user) {
        listOfLoggedUsers.put(user.getId(), user);
    }

    public void deleteUserFromLoggedList(User user) {
        listOfLoggedUsers.remove(user.getId());
    }

    public int getNumberOfLoggedUsers() {
        return listOfLoggedUsers.size();
    }

    public void printUserList() {
        for (Map.Entry<Integer, User> entry : listOfLoggedUsers.entrySet()) {
            System.out.println("|User list: " + entry.getKey() + " : " + entry.getValue());
        }
    }
}
