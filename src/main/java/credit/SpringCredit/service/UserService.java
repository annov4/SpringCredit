package credit.SpringCredit.service;


import credit.SpringCredit.model.Car;
import credit.SpringCredit.model.User;
import credit.SpringCredit.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @PostConstruct
    public void initDB() {
        createUser();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void createUser() {
        Car bmw = new Car("BMW", 5000000);
        User vasiliy = new User("Vasiliy", bmw);
        userRepository.save(vasiliy);

        User anton = new User("Anton");
        userRepository.save(anton);

        User pasha = new User("Pasha");
        userRepository.save(pasha);

        Car volvo = new Car("Volvo", 300000);
        User fedor = new User("Fedor", volvo);
        userRepository.save(fedor);

        Car faw = new Car("Faw", 400000);
        User sergey = new User("Sergey", faw);
        userRepository.save(sergey);

        Car exeed = new Car("Exeed", 100000);
        User roman = new User("Roman", exeed);
        userRepository.save(roman);

        Car fiat = new Car("Fiat", 300000);
        User galina = new User("Galina", fiat);
        userRepository.save(galina);

        Car mazda = new Car("Mazda", 6000000);
        User nasty = new User("Nasty", mazda);
        userRepository.save(nasty);

        User masha = new User("Masha");
        userRepository.save(masha);


    }
}