package by.morozmaksim.gpt_crud_users_ci_cd.repository;

import by.morozmaksim.gpt_crud_users_ci_cd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository - не указываем, так как есть extends JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
