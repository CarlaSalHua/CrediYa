package co.com.bancolombia.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String address;
    private String password;
    private String cellphone;
    private String email;
    private Double baseSalary;
}
