package education.shop.entities.Dto;

import java.util.Date;

public record UserRespDto(
        String firstName,
        String lastName,
        int age,
        String city,
        Integer postalCode,
        Date inscriptionDate,
        String email,
        String password,
        byte[] profilePicture,

        String phone

) {
}
