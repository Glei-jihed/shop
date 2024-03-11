package education.shop.services;


import education.shop.controllers.AuthenticationRequest;
import education.shop.controllers.AuthenticationResponse;
import education.shop.controllers.RegisterRequest;
import education.shop.entities.Role;
import education.shop.entities.User;
import education.shop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse userRegister(RegisterRequest request){
        var user = User.builder()
                .id(request.getId())
                .age(request.getAge())
                .phone(request.getPhone())
                .profilePicture(request.getProfilePicture())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .city(request.getCity())
                .postalCode(request.getPostalCode())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }







    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        user.setConnected(true);
        repository.save(user);


        return AuthenticationResponse.builder()
                .token(jwtToken)
                .id(user.getId())
                .role(String.valueOf(user.getRole()))
                .build();
    }

}