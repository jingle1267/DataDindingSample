package com.ihongqiqu.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ihongqiqu.databinding.data.User;
import com.ihongqiqu.databinding.databinding.ActivityDataBindingSample1Binding;
import com.ihongqiqu.databinding.databinding.ActivityDataBindingSample2Binding;
import com.ihongqiqu.databinding.event.MyHandlers;

/**
 * 事件绑定
 */
public class DataBindingSampleActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("事件绑定");

        User user = new User("jingle1267", "20");
        MyHandlers myHandlers = new MyHandlers();

        ActivityDataBindingSample2Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding_sample2);
        binding.setUser(user);
        binding.setMyHandlers(myHandlers);
    }

}
