package by.morozmaksim.gpt_crud_users_ci_cd.domain.exception;

public class UserEmailExistsException extends RuntimeException {
    public UserEmailExistsException(String message) {
        super(message);
    }
}
