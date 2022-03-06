package Data.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Data.DataModel.Task;

@Dao
public interface TaskDao {
    @Insert
    void insertAllTaskData(Task task);

    @Query("select* from Task")
    List<Task> getAllTaskData();
}
