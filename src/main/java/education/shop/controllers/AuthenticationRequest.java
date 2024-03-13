package education.shop.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class AuthenticationRequest {
    @Email(regexp = "*@*", message = "Enter a valid email please !")
    private String email;
    @Size(min = 8,max = 12,message = "Your password not valid !")
    private String password;
}
