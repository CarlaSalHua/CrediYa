package co.com.bancolombia.api.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UserDTO {
    private String id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate birthdate;

    private String address;

    private String password;

    private String cellphone;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String email;

    @NotNull(message = "El salario base es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El salario base debe ser mayor o igual a 0")
    @DecimalMax(value = "15000000.0", inclusive = true, message = "El salario base debe ser menor o igual a 15,000,000")
    private Double baseSalary;
}
