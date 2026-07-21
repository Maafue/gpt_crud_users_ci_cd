package by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateEmailUserRequest(
        @NotBlank(message = "Email must not be blank.")
        @Email(message = "Email must be valid.")
        String email) {
}
