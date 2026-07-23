package by.morozmaksim.gpt_crud_users_ci_cd.service;

import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse create (CreateUserRequest request);
    UserResponse update (Long id, UpdateUserRequest request);
    UserResponse updateEmail (Long id, UpdateEmailUserRequest request);
    UserResponse getById (Long id);
    Page<UserResponse> getAll (Pageable pageable, UserFilter filter);
    void delete(Long id);
}
