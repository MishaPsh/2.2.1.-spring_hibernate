package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImp implements CarService{
    @Autowired
    CarDao carDao;

    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    public List<User> listUsers() {
        return carDao.listUsers();
    }



}
