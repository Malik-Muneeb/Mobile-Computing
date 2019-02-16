package Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TeacherDAO {
    @Insert
    public void insertTeacher(Teacher teacher);

    @Query("Select * From teacher")
    public List<Teacher> getAllTeacher();
}
