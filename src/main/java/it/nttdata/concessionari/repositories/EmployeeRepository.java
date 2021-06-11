package it.nttdata.concessionari.repositories;

import it.nttdata.concessionari.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
