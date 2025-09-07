package models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {
    private String email;
    private String password;
}
