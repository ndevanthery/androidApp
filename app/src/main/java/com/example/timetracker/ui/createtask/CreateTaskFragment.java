package com.example.timetracker.ui.createtask;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.timetracker.MainActivity;
import com.example.timetracker.R;
import com.example.timetracker.databinding.FragmentCreatetaskBinding;

import java.sql.Time;

public class CreateTaskFragment extends Fragment {

    private FragmentCreatetaskBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CreateTaskViewModel dashboardViewModel =
                new ViewModelProvider(this).get(CreateTaskViewModel.class);

        binding = FragmentCreatetaskBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the task the user wants to create
                String description = binding.txtDescription.getText().toString();
                String endTime = binding.txtEndTime.getText().toString();
                String startTime = binding.txtStartTime.getText().toString();
                String title = binding.txtTitle.getText().toString();

                binding.txtTitle.setText("");
                binding.txtDescription.setText("");
                binding.txtEndTime.setText("");
                binding.txtStartTime.setText("");
            }
        });





        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}