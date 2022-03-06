package Data.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Data.DataModel.Employee;

@Dao
public interface EmployeeDao {

    @Insert
    void addEmployee(Employee employee);

    @Query("select * from Employee")
    List<Employee> getAllEmployeeData();
}
