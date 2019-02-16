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
import Database.Teacher;
import Database.TeacherDAO;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherFragment extends Fragment {


    public TeacherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teacher, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_teacher);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AppDatabase appDatabase = AppDatabase.getInstance(getActivity().getApplicationContext());
        TeacherDAO teacherDAO = appDatabase.teacherDAO();
        List<Teacher> teacherList = teacherDAO.getAllTeacher();
        TeacherAdapter teacherAdapter = new TeacherAdapter(teacherList);
        recyclerView.setAdapter(teacherAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(),
                        DividerItemDecoration.VERTICAL));
        return rootView;
    }

}
