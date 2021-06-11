package it.nttdata.concessionari.repositories;

import it.nttdata.concessionari.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
