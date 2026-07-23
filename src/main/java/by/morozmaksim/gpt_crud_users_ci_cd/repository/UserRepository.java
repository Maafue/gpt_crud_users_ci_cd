package by.morozmaksim.gpt_crud_users_ci_cd.repository;

import by.morozmaksim.gpt_crud_users_ci_cd.domain.User;
import by.morozmaksim.gpt_crud_users_ci_cd.web.dto.user.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//@Repository - не указываем, так как есть extends JpaRepository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    boolean existsByEmail(String email);

}
