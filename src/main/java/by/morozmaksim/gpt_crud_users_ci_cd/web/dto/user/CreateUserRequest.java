package by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank(message = "FirstName must not be blank.")
        String firstName,
        String lastName,
        String middleName,

        @NotBlank()
        @Email(message = "Email must be valid.")
        String email) {
}
