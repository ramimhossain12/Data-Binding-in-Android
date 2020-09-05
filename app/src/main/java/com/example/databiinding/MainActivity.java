package com.example.databiinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databiinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
             binding.setAStudent(new Student("Ramim Hossain",26));
             binding.setHandler(new EventHandler());



    }


    public  class EventHandler{

        public  void  handleClick(String  name  ){
            Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);

        }
    }

    public  class Student{

        private  String name;
        private  int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}