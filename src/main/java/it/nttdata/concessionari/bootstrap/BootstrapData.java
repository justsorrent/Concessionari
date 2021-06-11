package it.nttdata.concessionari.bootstrap;

import it.nttdata.concessionari.model.Car;
import it.nttdata.concessionari.model.Dealership;
import it.nttdata.concessionari.model.Employee;
import it.nttdata.concessionari.model.Region;
import it.nttdata.concessionari.repositories.CarRepository;
import it.nttdata.concessionari.repositories.DealershipRepository;
import it.nttdata.concessionari.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final DealershipRepository dealershipRepository;
    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;

    public BootstrapData(DealershipRepository dealershipRepository, CarRepository carRepository, EmployeeRepository employeeRepository) {
        this.dealershipRepository = dealershipRepository;
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Dealership dealer1 = new Dealership("BiteCar", Region.LOMBARDIA, "Via Roma", "Milano");
        Dealership dealer2 = new Dealership("NttCar", Region.LAZIO, "Via Milano", "Roma");

        Car car1 = new Car("Tesla Model 3", 44999d, dealer1);
        Car car2 = new Car("Volkswagen Polo", 23499d, dealer1);
        Car car3 = new Car("Mercedes classe A", 35000d, dealer2);
        Car car4 = new Car("BMW Serie 1", 37000d, dealer2);

        Employee employee1 = new Employee(dealer1, "Luca", "Sorrentino", 45000d, 22);
        Employee employee2 = new Employee(dealer1, "Roberto", "Sorrentino", 45000d, 53);
        Employee employee3 = new Employee(dealer2, "Michela", "Germani", 45000d, 22);
        Employee employee4 = new Employee(dealer2, "Emanuele", "Fiorito", 45000d, 51);

        dealer1.getCars().add(car1);
        dealer1.getCars().add(car2);
        dealer2.getCars().add(car3);
        dealer2.getCars().add(car4);

        dealer1.getEmployees().add(employee1);
        dealer1.getEmployees().add(employee2);
        dealer2.getEmployees().add(employee3);
        dealer2.getEmployees().add(employee4);

        dealershipRepository.save(dealer1);
        dealershipRepository.save(dealer2);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
    }
}
