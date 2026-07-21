package by.morozmaksim.gpt_crud_users_ci_cd.service;

import by.morozmaksim.gpt_crud_users_ci_cd.domain.User;
import by.morozmaksim.gpt_crud_users_ci_cd.domain.exception.UserEmailExistsException;
import by.morozmaksim.gpt_crud_users_ci_cd.domain.exception.ResourceNotFoundException;
import by.morozmaksim.gpt_crud_users_ci_cd.repository.UserRepository;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.CreateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateEmailUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UserResponse;
import by.morozmaksim.gpt_crud_users_ci_cd.web.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse create(CreateUserRequest request) {
        checkEmailExists(request.email());
        var user = userMapper.toEntity(request);
        var createdUser = userRepository.save(user);
        return userMapper.toResponse(createdUser);
    }

    @Override
    public UserResponse update(Long id, UpdateUserRequest request) {
        var user = getUserById(id);
        userMapper.update(user, request);
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateEmail(Long id, UpdateEmailUserRequest request) {
        var user = getUserById(id);
        checkEmailExists(request.email());
        userMapper.updateEmail(user, request);
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse getById(Long id) {
        return userMapper.toResponse(getUserById(id));
    }

    @Override
    public List<UserResponse> getAll() {
        return userMapper.toResponses(userRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getUserById(id));
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id=" + id + " not found."));
    }

    private void checkEmailExists(String email) {
        if (userRepository.existsByEmail(email))
            throw new UserEmailExistsException("User with email=" + email + " exists.");
    }
}
