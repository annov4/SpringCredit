package credit.SpringCredit.service;

import credit.SpringCredit.model.Car;
import credit.SpringCredit.model.User;
import credit.SpringCredit.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostConstruct
    public void createUser() {

        userRepository.save(new User("Vasiliy", new Car("BMW", 5000000)));

        userRepository.save(new User("Anton"));

        userRepository.save(new User("Pasha"));

        userRepository.save(new User("Fedor", new Car("Volvo", 300000)));

        userRepository.save(new User("Sergey", new Car("Faw", 400000)));

        userRepository.save(new User("Roman", new Car("Exeed", 100000)));

        userRepository.save(new User("Galina", new Car("Fiat", 300000)));

        userRepository.save(new User("Nasty", new Car("Mazda", 6000000)));

        userRepository.save(new User("Masha"));

    }
}