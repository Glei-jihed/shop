package education.shop.entities.Dto;

import java.util.Date;

public record UserRespForAdmin(

        String id,
        String firstName,
        String lastName,
        String age,
        String city,
        Integer postalCode,
        Date inscriptionDate,
        String email,
        String password,
        byte[] profilePicture,
        String phone
) {
}
