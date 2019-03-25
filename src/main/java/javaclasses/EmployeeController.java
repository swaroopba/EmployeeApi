package javaclasses;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService md;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		return md.getEmployees();
	}
	
	@RequestMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return md.getSpecificEmployee(id);
	}

	@RequestMapping(method=RequestMethod.POST,value="/employees")
		public void addEmployee(@RequestBody Employee emp) {
			md.addNewEmployee(emp);
			
		}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public void addEmployee(@PathVariable int id) {
		md.deleteEmployee(id);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}")
	public void updateEmployee(@RequestBody Employee emp,@PathVariable int id) {
		md.updateEmployee(id,emp);
		
	}
	
	
	


}
	

