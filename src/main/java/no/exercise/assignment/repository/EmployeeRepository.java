package no.exercise.assignment.repository;

import no.exercise.assignment.dto.EmployeeDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDto,Integer> {


    @Query("SELECT * FROM PERSON WHERE PERSON.ID = :id")
    EmployeeDto findByEmployeeId(@Param("id") Integer personId);

    @Query("SELECT ID,NAME,AGE, START_DATE FROM PERSON INNER JOIN EMPLOYEE ON EMPLOYEE.PERSON_ID = PERSON.ID WHERE END_DATE IS NULL")
    List<EmployeeDto> getActiveEmployees();

    @Query("SELECT PERSON.NAME,PERSON.AGE, DEPARTMENT.NAME AS DEPARTMENT_NAME, START_DATE, END_DATE FROM PERSON INNER JOIN EMPLOYEE ON EMPLOYEE.PERSON_ID = PERSON.ID JOIN DEPARTMENT ON DEPARTMENT.ID = EMPLOYEE.DEPARTMENT_ID WHERE EMPLOYEE.END_DATE IS NULL GROUP BY  DEPARTMENT.NAME,PERSON.NAME,PERSON.AGE")
    List<EmployeeDto>getAllActiveEmployeesByDepartment();




}
