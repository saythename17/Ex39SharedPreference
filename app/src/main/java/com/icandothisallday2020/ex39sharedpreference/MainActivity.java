package com.icandothisallday2020.ex39sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_age;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
        tv=findViewById(R.id.tv);
    }

    public void clickSave(View view) {
        //저장할 데이터 얻어오기
        String name=et_name.getText().toString();
        String ageStr=et_age.getText().toString();
        int age;
        try{age=Integer.parseInt(ageStr);
        }catch(Exception e){age=0;}
        //내부메모리-Data.xml 문서에 데이터를 저장해주는 객체
        SharedPreferences pref =getSharedPreferences("Data",MODE_PRIVATE);
        //설정을 목적으로 만들었기에 MODE_PRIVATE  이 권장사항
        //Preference: 해당 화면에서만 사용가능
        SharedPreferences.Editor editor=pref.edit();//문서 저장시작
        editor.putString("Name",name);
        editor.putInt("Age",age);
        editor.commit();
    }

    public void clickLoad(View view) {
        SharedPreferences pref=getSharedPreferences("Data",MODE_PRIVATE);
        String name=pref.getString("Name","No Name");
        int age=pref.getInt("Age",0);//:저장안되있으면 기본값
        tv.setText(name+"\n"+age);
    }
}
