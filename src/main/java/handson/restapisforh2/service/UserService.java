package handson.restapisforh2.service;

import handson.restapisforh2.entity.UserTable;
import handson.restapisforh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUserToDb(UserTable user) {
        userRepository.save(user);
    }

    public Optional<UserTable> getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<UserTable> getAllUsers() {
        List<UserTable> userList = userRepository.findAll();
        return userList;
    }

    public String updateUserById(int id, UserTable user) {
        UserTable updatedEntity = userRepository.findById(id).orElse(new UserTable());
        userRepository.save(user);
        return "done";
    }
}
