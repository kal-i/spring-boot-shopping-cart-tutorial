package com.kali.kali_shops.service.user;

import com.kali.kali_shops.dto.UserDto;
import com.kali.kali_shops.model.User;
import com.kali.kali_shops.request.CreateUserRequest;
import com.kali.kali_shops.request.UpdateUserRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(Long userId, UpdateUserRequest request);
    void deleteUser(Long userId);

    UserDto convertToDto(User user);
}
