package by.morozmaksim.gpt_crud_users_ci_cd.domain;

import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UserFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserSpecifications {

    public Specification<User> fromFilter(UserFilter filter) {
        Specification<User> specification = Specification.unrestricted();
        specification = specification.and(emailEquals(filter.email()));
        specification = specification.and(createdAtEquals(filter.createdAt()));
        return specification;
    }


    private Specification<User> emailEquals(String email) {
        if (email == null) return null;
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("email"), email);
    }
    private Specification<User> createdAtEquals(LocalDateTime createdAt) {
        if (createdAt == null) return null;
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("createdAt"), createdAt);
    }
}
