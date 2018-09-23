package jp.nmemoto.todo.lib;

import jp.nmemoto.todo.domain.model.User;

import java.util.ArrayList;

public class LoginUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public User getUser() {
        return user;
    }

    public LoginUser(User user) {
        super(user.getUsername(), user.getPassword(), new ArrayList<>());
        this.user = user;
    }

}
