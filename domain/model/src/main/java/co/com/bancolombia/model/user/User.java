package co.com.bancolombia.model.user;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class User {
    private String  id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String address;
    private String cellphone;
    private String email;
    private String password;
    private Double baseSalary;
}
