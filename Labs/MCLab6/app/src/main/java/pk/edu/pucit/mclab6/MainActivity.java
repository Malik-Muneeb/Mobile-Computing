package pk.edu.pucit.mclab6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import Database.AppDatabase;
import Database.Student;
import Database.StudentDAO;
import Database.Teacher;
import Database.TeacherDAO;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonTeacher, buttonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populateData();
        initialize();
    }

    private void initialize() {
        buttonTeacher = findViewById(R.id.button_teacher_activity_main);
        buttonStudent = findViewById(R.id.button_student_activity_main);
        buttonTeacher.setOnClickListener(this);
        buttonStudent.setOnClickListener(this);
    }

    private void populateData() {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        StudentDAO studentDAO = appDatabase.studentDAO();
        Student student = new Student();
        student.setName("Muneeb");
        student.setEmail("Muneeb@gmail.com");
        studentDAO.insertStudent(student);

        student.setName("Nouman");
        student.setEmail("Nouman@gmail.com");
        studentDAO.insertStudent(student);

        student.setName("Junaid");
        student.setEmail("Junaid@gmail.com");
        studentDAO.insertStudent(student);

        student.setName("Sher");
        student.setEmail("Sher@gmail.com");
        studentDAO.insertStudent(student);

        student.setName("Adeel");
        student.setEmail("Adeel@gmail.com");
        studentDAO.insertStudent(student);

        TeacherDAO teacherDAO = appDatabase.teacherDAO();
        Teacher teacher = new Teacher();
        teacher.setName("Anum Tariq");
        teacher.setEmail("Anum@gmail.com");
        teacherDAO.insertTeacher(teacher);

        teacher.setName("Nazar Khan");
        teacher.setEmail("Nazar@gmail.com");
        teacherDAO.insertTeacher(teacher);

        teacher.setName("Tariq Butt");
        teacher.setEmail("Tariq@gmail.com");
        teacherDAO.insertTeacher(teacher);

        teacher.setName("Maliha Nadeem");
        teacher.setEmail("Maliha@gmail.com");
        teacherDAO.insertTeacher(teacher);

        teacher.setName("Bilal Shahzad");
        teacher.setEmail("Bilal@gmail.com");
        teacherDAO.insertTeacher(teacher);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_teacher_activity_main) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new TeacherFragment())
                    .commit();
        } else if (v.getId() == R.id.button_student_activity_main) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new StudentFragment())
                    .commit();

        }
    }
}
