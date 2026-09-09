package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
private String username;
private String password;
private String firstName;
private String lastName;

}
