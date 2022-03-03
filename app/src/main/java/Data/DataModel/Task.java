package Data.DataModel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
    public class Task {

        @PrimaryKey
        public int id;
        public String Taskname;
        public String Description;
        public int StartTime;
        public int EndTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskname() {
        return Taskname;
    }

    public void setTaskname(String taskname) {
        Taskname = taskname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStartTime() {
        return StartTime;
    }

    public void setStartTime(int startTime) {
        StartTime = startTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public void setEndTime(int endTime) {
        EndTime = endTime;
    }
}

