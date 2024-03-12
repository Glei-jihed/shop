package education.shop.controllers;

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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int postalCode;
    private Date inscriptionDate;
    private String city;
    private boolean connected;
    private int age;
    private String phone;
    private byte[] profilePicture;
}