package javaclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	List<Employee> employees = new ArrayList<Employee>();
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getEmployees() {
		
	/*employees.add(new Employee(1,"abc",23,"manager"));
	employees.add(new Employee(2,"bcd",24,"peon"));
	employees.add(new Employee(3,"cde",25,"emp"));
	employees.add(new Employee(4,"efg",26,"emp"));*/
		List<Employee> bank = new ArrayList<>(); 
		employeeRepo.findAll().forEach(bank::add);
	
	return bank;
	}

	public Optional<Employee> getSpecificEmployee(int id) {
		/*for(Employee e:employees) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;*/
		return employeeRepo.findById(id);
		
	}

	public void addNewEmployee(Employee emp) {
		//employees.add(emp);
		employeeRepo.save(emp);
	}

	public void deleteEmployee(int id) {
	 /*Employee e1=new Employee();
		for(Employee e:employees) {
			if(e.getId() == id) {
				e1.equals(e);
			}
		}
		employees.remove(e1);*/
		
		employeeRepo.deleteById(id);
	}

	public void updateEmployee(int id, Employee emp) {
		employeeRepo.save(emp);
		
	}	
}