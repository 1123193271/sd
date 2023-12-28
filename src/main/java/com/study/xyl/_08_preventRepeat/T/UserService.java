package com.study.xyl._08_preventRepeat.T;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    @RepeatSubmit
    public GenericResponse<User> addUser(User user) {
        return GenericResponse.success(user);
    }
}
