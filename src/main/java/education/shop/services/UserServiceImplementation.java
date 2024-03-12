package education.shop.services;


import education.shop.entities.User;
import education.shop.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{


    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    @Override
    public List<User> userDelete(User user) {

        userRepository.deleteById(user.getId());

        return userRepository.findAll();

    }

    @Override
    public Optional<User> findById(String id) {

        return Optional.of(userRepository.findById(id)).orElse(null);

    }


    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isEmpty())
        {
            return null;

        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User logoutUser(User user) {
        Optional<User> user2 = findById(user.getId());
        if (user2.isEmpty()){
            return  null;
        }
        user2.get().setConnected(false);
        return userRepository.save(user2.get());
    }

    @Override
    public User createGame(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isEmpty())
        {
            return null;
        } else {
            return userRepository.save(user);
        }
    }


    //=====================================  Admin filters =============================================================


    @Override
    public List<User> findByConnected(boolean connected) {
        return userRepository.findByConnected(connected);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<User> findByAgeBefore(int age) {
        return userRepository.findByAgeBefore(18);
    }

    @Override
    public List<User> findByAgeAfter(int age) {
        return userRepository.findByAgeAfter(25);
    }

    @Override
    public List<User> findByAgeBetween(int min, int max) {
        return userRepository.findByAgeBetween(18,25);
    }

    @Override
    public List<User> findByFirstNameOrLastNameLike(String keyword) {
        return userRepository.findByFirstNameOrLastNameLike(keyword);
    }


}
