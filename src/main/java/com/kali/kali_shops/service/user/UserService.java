package com.kali.kali_shops.service.user;

import com.kali.kali_shops.dto.UserDto;
import com.kali.kali_shops.exceptions.AlreadyExistsException;
import com.kali.kali_shops.exceptions.ResourceNotFoundException;
import com.kali.kali_shops.model.User;
import com.kali.kali_shops.repository.UserRepository;
import com.kali.kali_shops.request.CreateUserRequest;
import com.kali.kali_shops.request.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                        .map(req -> {
                            User user =  new User();
                            user.setFirstName(request.getFirstName());
                            user.setLastName(request.getLstName());
                            user.setEmail(request.getEmail());
                            user.setPassword(passwordEncoder.encode(req.getPassword()));
                            return  userRepository.save(user);
                        }).orElseThrow(() -> new AlreadyExistsException(request.getEmail() + " already exists"));

    }

    @Override
    public User updateUser(Long userId, UpdateUserRequest request) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setFirstName(request.getFirstName());
                    existingUser.setLastName(request.getLstName());
                    return userRepository.save(existingUser);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(userRepository :: delete, () -> {
                    throw new ResourceNotFoundException("User not found");
                        });
    }

    @Override
    public UserDto convertToDto(User user) {
        return  modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email);
    }
}
