package Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public void insertStudent(Student student);

    @Query("Select * From student")
    public List<Student> getAllStudent();
}
