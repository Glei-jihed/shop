package education.shop.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterRequest {
    private String id;
    @NotBlank(message = "Enter your first name please !")
    private String firstName;
    @NotBlank(message = "Enter your last name please !")
    private String lastName;
    @Email(regexp = "*@*",message = "Enter a valid email please !")
    private String email;
    @Size(min = 8,max = 12,message = "Your password should have between 8 and 12 char")
    private String password;
    @Positive(message = "Your postal code should be positive !")
    private int postalCode;
    private Date inscriptionDate;
    @NotBlank(message = "Enter your city")
    private String city;
    private boolean connected;
    @Positive
    private int age;
    @Size(min = 8,max=8,message = "Enter a valid phone number your phone number, should have 8 numbers !")
    private String phone;
    private byte[] profilePicture;
}