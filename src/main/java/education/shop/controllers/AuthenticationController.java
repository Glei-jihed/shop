package education.shop.controllers;


import education.shop.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    /**
     * @author: Glei jihed
     * we use this endpoint to register as a player
     * @param request this request contain the user details
     * @return AuthenticationResponse
     */
    @PostMapping(path = "/user/register")
    public ResponseEntity<AuthenticationResponse> userRegister(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.userRegister(request));
    }


    /**
     * @author: Glei jihed
     * we use this endpoint to authenticate user and get a token which will be used to access
     * @param request this request contain the user details
     * @return token
     */
    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
