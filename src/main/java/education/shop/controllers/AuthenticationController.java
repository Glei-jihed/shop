package education.shop.controllers;


import education.shop.requests.AuthenticationRequest;
import education.shop.requests.AuthenticationResponse;
import education.shop.requests.RegisterRequest;
import education.shop.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


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
    @PostMapping(path = "/users/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    //===================================== Exception Handling =========================================================
    @ExceptionHandler
    public ResponseEntity<?> handleMethodArgumentNotFoundException(MethodArgumentNotValidException exp){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);

                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
