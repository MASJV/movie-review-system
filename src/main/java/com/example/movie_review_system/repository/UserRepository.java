package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    public List<User> userList;

    public UserRepository() {
        userList = new LinkedList<>();
    }

    @Override
    public User getAUser(int userId) throws UserNotFoundException {
        for (User user : userList) {
            if (user.getUserId() == userId) return user;
        }
        throw new UserNotFoundException("User Not Found");
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public void createAUser(User user) {
        userList.add(user);
    }

    @Override
    public User updateAUser(int userId, String name) throws UserNotFoundException {
        User user = getAUser(userId);
        user.setName(name);
        return user;
    }

//    @Override
//    public User deleteAUser(int userId) throws UserNotFoundException {
//        for (User user : userList) {
//            if (user.getUserId() == userId) userList.remove(user);
//            return user;
//        }
//        throw new UserNotFoundException("User Not Found");
//    }
}