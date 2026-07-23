package by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user;

import java.time.LocalDateTime;

public record UserFilter(String email,
                         LocalDateTime createdAt) {
}
