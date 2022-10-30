package com.hcl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

		@Query(value = "SELECT * FROM employee e where e.ename like %?1%",nativeQuery=true)
		List<Employee> findByEname(String name);
		
		@Query(value = "SELECT * FROM employee e where e.city like %?1% AND e.dept like %?2%",nativeQuery=true)
		public List<Employee> findByCityAndDept(String city, String dept);
		
		@Query(value = "SELECT * FROM employee e where e.ename like :lastname%", nativeQuery = true)
		public List<Employee> findByLastName(@Param("lastname") String lastname);
		
		public List<Employee> findAllByOrderByEnoAsc();
		
		@Query(value = "SELECT * FROM employee e where e.eno = ?1",nativeQuery=true)
		public Employee findById(int id);
		
		@Query(value = "SELECT * FROM employee e where e.eno = ?1",nativeQuery=true)
		public List<Employee> findAllById(int id);
		
		@Query(value="UPDATE Employee set ename = :ename, email = :email, address = :address, phone = :phone, dept = :dept WHERE eno = :eno",nativeQuery = true)
		public void updateEmp(String ename, String email, String address, String phone, String dept, int eno);
			
		
		
}
	