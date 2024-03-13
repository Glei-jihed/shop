package education.shop.mappers;


import education.shop.entities.Dto.UserRespDto;

import education.shop.entities.Dto.UserRespForAdmin;
import education.shop.entities.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserMapper {
    public UserRespDto toUserRespDto(User user){
       return new UserRespDto(
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getCity(),
                user.getPostalCode(),
                user.getInscriptionDate(),
                user.getEmail(),
                user.getPassword(),
                user.getProfilePicture(),
                user.getPhone()
       );

    }

    public UserRespForAdmin toUserRespForAdmin(User user){
        return new UserRespForAdmin(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getCity(),
                user.getPostalCode(),
                user.getInscriptionDate(),
                user.getEmail(),
                user.getPhone()
        );
    }

}
