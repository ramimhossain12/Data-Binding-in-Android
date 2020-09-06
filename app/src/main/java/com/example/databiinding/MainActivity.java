package com.example.databiinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.PropertyChangeRegistry;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.databiinding.databinding.ActivityMainBinding;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);

        final Student aStudent = new Student("Ramim Hossain",99);
        aStudent.setImageUrl("https://images.pexels.com/photos/1413412/pexels-photo-1413412.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");

        binding.setAStudent(aStudent);



    }




    public  class Student implements Observable {


        private PropertyChangeRegistry registry = new PropertyChangeRegistry();
        private String  name;
        private  int age;
        private  String imageUrl;




        public Student(String name, int age) {
            this.name=name;
            this.age = age;
        }


        public void setName(String name) {
            this.name=name;
            registry.notifyChange(this,BR.name);
        }
           @Bindable
        public String getName() {
            return name;
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

        @Override

        public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

            registry.add(callback);
            
        }

        @Override
        public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {


            registry.remove(callback );
        }
    }

    private void notifyPropertyChanged(int name) {

    }

    @BindingAdapter("imageUrl")
    public static  void  loadimage(ImageView imageView, String url ){

        Glide.with(imageView.getContext())
                .load(url)
                .fitCenter()
                .into(imageView);
    }
}