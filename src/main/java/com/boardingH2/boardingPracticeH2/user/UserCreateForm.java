package com.boardingH2.boardingPracticeH2.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수 항목입니다")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 항목입니다")
    private String password1;

    @NotEmpty(message = "비밀번호는 필수 항목입니다")
    private String password2;
    @NotEmpty(message = "email은 필수 항목입니다")
    @Email
    private String email;
}
