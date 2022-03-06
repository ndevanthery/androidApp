package Data.DataBase;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Data.DaoClass.EmployeeDao;
import Data.DaoClass.TaskDao;
import Data.DataModel.Employee;
import Data.DataModel.Task;

@Database(entities ={Employee.class, Task.class}, version = 1 )
public abstract class DataBaseClass extends RoomDatabase {

        private static final String DB_NAME ="postWorker_DB";
        private static DataBaseClass instance;


        public static synchronized DataBaseClass getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(), DataBaseClass.class, DB_NAME)
                        .fallbackToDestructiveMigration().allowMainThreadQueries().build();

            }
            return instance;
        }


    public abstract EmployeeDao employeeDao();
        public abstract TaskDao taskDao();

}




