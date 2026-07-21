package by.morozmaksim.gpt_crud_users_ci_cd.domain.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ExceptionBody {
    private String message;
    private Map<String, String> errors;
}
