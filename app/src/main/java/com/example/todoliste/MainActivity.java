package com.example.todoliste;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText taskInput;
    private Button addButton;
    private ListView taskList;
    private List<String> tasks;
    private TaskItem taskItem;
    private Button completedTasks;
    private List<String> completedTasksList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);

        taskInput = findViewById(R.id.task_input);
        taskList = findViewById(R.id.task_list);



        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        completedTasks = findViewById(R.id.Completed_tasks_button);
        completedTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(MainActivity.this, CompletedTasks.class));
            }
        });
        
        tasks = new ArrayList<>();
        completedTasksList = new ArrayList<>();
        taskItem = new TaskItem(this, tasks);
        taskList.setAdapter(taskItem);

        //setUpListViewListener();


    }

    private void setUpListViewListener() {
        taskList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Task Removed", Toast.LENGTH_LONG).show();
                tasks.remove(position);
                taskItem.notifyDataSetChanged();
                return true;
            }

        });
    }


    private void addTask() {
        EditText input = findViewById(R.id.task_input);
        String taskName = input.getText().toString();

        if (!(taskName.equals(""))) {
            tasks.add(taskName);
            taskItem.notifyDataSetChanged();
            taskInput.getText().clear();
        } else {
            Toast.makeText(this, "Please enter a task in the Task field", Toast.LENGTH_SHORT).show();
        }
    }

}



