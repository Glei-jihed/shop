package education.shop.mappers;

import education.shop.entities.Dto.UserRespDto;
import education.shop.entities.Dto.UserRespForAdmin;
import education.shop.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    void shouldMapUserToUserRespDto() {

        //Given
        User user = new User("123","jihed","glei",23,"Paris",75015,"glei.jihed@gmail.com","jihed@123","0753129330",true);

        //When
        UserRespDto dto = userMapper.toUserRespDto(user);

        //Then
        assertEquals(dto.firstName(),user.getFirstName());
        assertEquals(dto.email(),user.getEmail());
        assertEquals(dto.lastName(),user.getLastName());
        System.out.println("User To userRespDto done !");


    }


    @Test
    void shouldMapUserToUserRespForAdminDto() {

        //Given
        User user = new User("123","jihed","glei",23,"Paris",75015,"glei.jihed@gmail.com","jihed@123","0753129330",true);

        //When
        UserRespForAdmin dto = userMapper.toUserRespForAdmin(user);

        //Then
        assertEquals(dto.firstName(),user.getFirstName());
        assertEquals(dto.email(),user.getEmail());
        assertEquals(dto.lastName(),user.getLastName());
        System.out.println("User To userRespForAdmin done !");


    }



}