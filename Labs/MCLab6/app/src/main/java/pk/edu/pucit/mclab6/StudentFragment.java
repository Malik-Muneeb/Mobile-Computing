package pk.edu.pucit.mclab6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Database.AppDatabase;
import Database.Student;
import Database.StudentDAO;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {


    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_student);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AppDatabase appDatabase = AppDatabase.getInstance(getActivity().getApplicationContext());
        StudentDAO studentDAO = appDatabase.studentDAO();
        List<Student> studentList = studentDAO.getAllStudent();
        StudentAdapter studentAdapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(),
                        DividerItemDecoration.VERTICAL));
        return rootView;
    }

}
