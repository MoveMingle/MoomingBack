package com.example.mooming.domain.members;

import com.example.mooming.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@Getter
@Table(name = "member")
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String tel;     // 전화번호

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String name, String email, String password, String tel, MemberRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.role = role;
    }

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .name(memberFormDto.getName())
                .email(memberFormDto.getEmail())
                .tel(memberFormDto.getTel())
                .password(passwordEncoder.encode(memberFormDto.getPassword()))      // 암호화 처리
                .role(MemberRole.USER)
                .build();
        return member;
    }

}
