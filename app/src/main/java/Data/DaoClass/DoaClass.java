package Data.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Data.DataModel.Employee;
import Data.DataModel.Task;

@Dao
public interface DoaClass {

    @Insert
    void insertAllEmployeeData(Employee employee);

    @Query("select * from Employee")
    List<Employee> getAllEmployeeData();

    @Insert
    void insertAllTaskData(Task task);

    @Query("select* from Task")
    List<Task> getAllTaskData();

}
