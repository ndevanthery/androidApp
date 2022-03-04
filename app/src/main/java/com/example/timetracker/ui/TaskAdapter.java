package com.example.timetracker.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.timetracker.R;
import com.example.timetracker.databinding.FragmentHistoryBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.zip.Inflater;

import Data.DataModel.Task;

public class TaskAdapter extends ArrayAdapter<Task> {
    public static final String RED = "\033[0;31m";     // RED
    public static final String YELLOW = "\033[0;33m";  // YELLOW

    public static final String RESET = "\033[0m";  // Text Reset

    private List<Task> items;
    private int layoutResourceId;
    private Context context;
    private LayoutInflater inflater;

    public TaskAdapter(Context context, int layoutResourceId, List<Task> items, LayoutInflater inflater) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
        this.inflater = inflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TaskHolder holder = null;


        //LayoutInflater inflater = ((Fragment) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new TaskHolder();
        holder.task = items.get(position);
        holder.details = (Button)row.findViewById(R.id.btnDetails);
        holder.details.setTag(holder.task);

        holder.delete = (FloatingActionButton)row.findViewById(R.id.btnDelete);
        holder.delete.setTag(holder.task);

        holder.title = (TextView)row.findViewById(R.id.lblTitle);
        holder.startTime = (TextView)row.findViewById(R.id.lblStartTask);
        holder.endTime = (TextView)row.findViewById(R.id.lblEndTask);
        holder.date = (TextView)row.findViewById(R.id.lblDate);


        row.setTag(holder);

        setupItem(holder);
        return row;
    }

    private void setupItem(TaskHolder holder) {
        holder.title.setText(holder.task.getTaskname());
        holder.startTime.setText(Integer.toString(holder.task.getStartTime()));
        holder.endTime.setText(Integer.toString(holder.task.getEndTime()));
        holder.date.setText(holder.task.getDate());
        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.println(Log.WARN,"DETAILS PUSHED",holder.task.getTaskname()+" asked for his details");
//                System.out.println(YELLOW +"DETAILS BUTTON WAS PUSHED ON " + holder.task.getTaskname()+RESET);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.println(Log.ERROR,"DELETE PUSHED ",holder.task.getTaskname()+" asked to be deleted");
                Task itemToRemove = (Task)view.getTag();
                remove(itemToRemove);
            }
        });
    }

    public static class TaskHolder {
        Task task;
        TextView title;
        TextView startTime;
        TextView endTime;
        TextView date;
        Button details;
        FloatingActionButton delete;
    }
}