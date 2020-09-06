package com.example.databiinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.databiinding.databinding.ActivityMainBinding;

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
        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                aStudent.setName(editable.toString());

            }
        });



    }




    public  class Student{

        private ObservableField<String> name = new ObservableField<>();
        private  int age;
        private  String imageUrl;




        public Student(String name, int age) {
            this.name.set(name);
            this.age = age;
        }


        public void setName(String name) {
            this.name.set(name);
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
    public static  void  loadimage(ImageView imageView, String url ){

        Glide.with(imageView.getContext())
                .load(url)
                .fitCenter()
                .into(imageView);
    }
}