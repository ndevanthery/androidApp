package Data.DataBase;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Data.DaoClass.DoaClass;
import Data.DataModel.Employee;
import Data.DataModel.Task;

@Database(entities ={Employee.class, Task.class}, version = 1 )
public abstract class DataBaseClass extends RoomDatabase {
    public abstract DoaClass getDoa();
    private static DataBaseClass instance;
    static DataBaseClass getDataBase(final Context context){
        if(instance==null){
            synchronized (DataBaseClass.class){
                instance= Room.databaseBuilder(context, DataBaseClass.class, "DATABASE").build();
            }
        }
        return instance;
    }
}


