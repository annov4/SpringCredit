package credit.SpringCredit.dao;

import credit.SpringCredit.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("BMW", 5000000));
        carList.add(new Car("Toyota", 500000));
        carList.add(new Car("audi", 50000));
        carList.add(new Car("Ford", 350000));
        carList.add(new Car("Lexus", 170000));
        carList.add(new Car("Gelly", 2000000));
        carList.add(new Car("Changan", 20000));
        carList.add(new Car("Rolls-Royce", 50000000));
        carList.add(new Car("Mini", 700000));
        carList.add(new Car("Skoda", 100000));
        carList.add(new Car("Citroen", 400000));
    }

}
