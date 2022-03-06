package com.example.timetracker.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.timetracker.R;
import com.example.timetracker.databinding.FragmentHistoryBinding;
import com.example.timetracker.ui.TaskAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Data.DataModel.Task;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private View root;
    ListView list;
    private TaskAdapter myAdapter;
    ListView simpleList;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand"};
    List<HashMap> myList = new ArrayList<HashMap>();
    String from[] = {"title" , "startTime","endTime","date"};
    int to[]={R.id.lblTitle, R.id.lblStartTask, R.id.lblEndTask,R.id.lblDate};
    String titles[] = {"titre1","titre2","titre3","titre4"};
    String starttimes[] = {"starttimes1","starttimes2","starttimes3","starttimes4"};
    int starttimesint[] = {12,16,22,26};
    String endtimes[]={"endtime1","endtime2","endtime3","endtime4"};
    int endtimesint[]={23,45,63,21};
    String dates[]={"date1","date2","date3","date4"};
    int datesint[]={76,7,4,24};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel homeViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();

        ArrayList<Task> myListOfTasks = new ArrayList<>();
        // By a for loop, entering different types of data in HashMap,
        // and adding this map including it's datas into the ArrayList
        // as list item and this list is the second parameter of the SimpleAdapter
        for (int i = 0; i < titles.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("title", titles[i]);
            map.put("startTime", starttimes[i]);
            map.put("endTime", endtimes[i]);
            map.put("date", dates[i]);

            Task mytask = new Task();
            mytask.setTaskname(titles[i]);
            mytask.setStartTime(starttimesint[i]);
            mytask.setEndTime(endtimesint[i]);
            mytask.setDate(dates[i]);
            myListOfTasks.add(mytask);

            // adding the HashMap to the ArrayList
            listmap.add(map);
        }




        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        //simpleList.setAdapter(arrayAdapter);
//        View v = inflater.inflate(R.layout.fragment_history, container,false);
        list = (ListView)root.findViewById(R.id.myListViewHistory);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(),R.layout.fragment_history,R.id.txt,countryList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), R.layout.history_task_fragment, R.id.lblTitle, countryList);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listmap, R.layout.history_task_fragment, from,to);
        myAdapter = new TaskAdapter(getActivity().getBaseContext(),R.layout.history_task_fragment,myListOfTasks,inflater);
        list.setAdapter(myAdapter);



//        HistoryTaskView myTask = new HistoryTaskView(binding.getRoot().getContext())
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }







    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void removePayOnClickHandler(View v) {
        Task item = (Task)v.getTag();
        System.out.println(item.getTaskname() + " " + item.getDate());
    }


}