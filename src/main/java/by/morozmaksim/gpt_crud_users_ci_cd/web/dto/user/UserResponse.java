package by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String middleName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
