package com.codefair.solobob;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RegisterUserTO {

    private String email;
    private String password;
    private String name;
}
