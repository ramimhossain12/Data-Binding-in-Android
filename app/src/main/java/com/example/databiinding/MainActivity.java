package com.example.databiinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.databiinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);

        Student aStudent = new Student("Ramim Hossain",99);
        aStudent.setImageUrl("https://images.pexels.com/photos/1413412/pexels-photo-1413412.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        aStudent.setImageUrl("https://images.pexels.com/photos/1172675/pexels-photo-1172675.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        binding.setAStudent(aStudent);



    }




    public  class Student{

        private  String name;
        private  int age;
        private  String imageUrl;
        private String imageUrl1;



        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getImageUrl1() {
            return imageUrl1;
        }

        public void setImageUrl1(String imageUrl1) {
            this.imageUrl1 = imageUrl1;
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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    @BindingAdapter("imageUrl")
    public static  void  loadimage(ImageView imageView, String url){

        Glide.with(imageView.getContext())
                .load(url)
                .fitCenter()
                .into(imageView);
    }
}