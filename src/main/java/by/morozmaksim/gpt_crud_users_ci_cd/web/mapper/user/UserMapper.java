package by.morozmaksim.gpt_crud_users_ci_cd.web.mapper.user;

import by.morozmaksim.gpt_crud_users_ci_cd.domain.User;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.CreateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateEmailUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UpdateUserRequest;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UserResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper{
    User toEntity (CreateUserRequest request);
    UserResponse toResponse(User user);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "middleName", source = "middleName")
    void update(@MappingTarget User user, UpdateUserRequest request);

    List<UserResponse> toResponses(List<User> users);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "email", source = "email")
    User updateEmail(@MappingTarget User user, UpdateEmailUserRequest request);
}
