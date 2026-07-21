package by.morozmaksim.gpt_crud_users_ci_cd.web.controller;

import by.morozmaksim.gpt_crud_users_ci_cd.service.UserService;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.CreateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateEmailUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UserResponse;
import by.morozmaksim.gpt_crud_users_ci_cd.web.mapper.user.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    public UserResponse create(@RequestBody @Valid CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/{id}")
    public UserResponse update(@RequestBody @Valid UpdateUserRequest request,
                               @PathVariable Long id) {
        return userService.update(id, request);
    }

    @PutMapping("/{id}/updateEmail")
    public UserResponse updateEmail(@RequestBody @Valid UpdateEmailUserRequest request,
                                    @PathVariable Long id) {
        return userService.updateEmail(id, request);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }
}
