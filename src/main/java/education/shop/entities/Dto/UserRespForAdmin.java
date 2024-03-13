package education.shop.entities.Dto;

import java.util.Date;

public record UserRespForAdmin(

        String id,
        String firstName,
        String lastName,
        int age,
        String city,
        Integer postalCode,
        Date inscriptionDate,
        String email,

        String phone
) {
}
