package com.example.mooming.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Data
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 입력 값이다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값이다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값이다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    @NotEmpty(message = "전화번호 필수 입력 값이다.")
    private String tel;

    @Builder
    public MemberFormDto(String name, String email, String password, String tel) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }
}
