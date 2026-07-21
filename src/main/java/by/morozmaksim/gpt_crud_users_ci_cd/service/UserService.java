package by.morozmaksim.gpt_crud_users_ci_cd.service;

import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.CreateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateEmailUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create (CreateUserRequest request);
    UserResponse update (Long id, UpdateUserRequest request);
    UserResponse updateEmail (Long id, UpdateEmailUserRequest request);
    UserResponse getById (Long id);
    List<UserResponse> getAll ();
    void delete(Long id);
}
