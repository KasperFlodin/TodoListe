package com.example.todoliste;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Console;
import java.util.List;

public class TaskItem extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mTasks;
    private List<String> completedTasksList;

    public TaskItem(Context context, List<String> tasks) {
        super(context, R.layout.activity_task_item, tasks);
        mContext = context;
        mTasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String task = mTasks.get(position);
        //int viewType = getItemViewType(position);

        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_task_item, parent, false);
        }


        TextView textViewTask = listItem.findViewById(R.id.textViewTask);
        CheckBox checkBoxTask = listItem.findViewById(R.id.task_checkbox);

        textViewTask.setText(task);
        System.out.println(checkBoxTask.isChecked());


        return listItem;
    }

    /*
    private void setUpListViewListener() {
        CheckBox checkBoxTask = tasks.findViewById(R.id.task_checkbox);
        if (checkBoxTask.isChecked()) {
            mTasks.remove(position);
            System.out.println("Delete");
            //Toast.makeText(mContext,"deleted", Toast.LENGTH_LONG).show();
        } else {

        }
    }
     */

    public void editItem(int position) {
        String task = mTasks.get(position);

    }

}

