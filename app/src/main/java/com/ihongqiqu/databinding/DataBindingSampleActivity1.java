package com.ihongqiqu.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ihongqiqu.databinding.data.User;
import com.ihongqiqu.databinding.BR;
import com.ihongqiqu.databinding.databinding.ActivityDataBindingSample1Binding;
import com.ihongqiqu.databinding.event.MyHandlers;

/**
 * 数据绑定
 */
public class DataBindingSampleActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("数据绑定");

        User user = new User("jingle1267", "20");

        // 第一种初始化方式
        ActivityDataBindingSample1Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding_sample1);
        binding.setUser(user);

        // 第二种初始化方式
//        ViewDataBinding binding1 = DataBindingUtil.setContentView(this,
//                R.layout.activity_data_binding_sample1);
//        binding1.setVariable(BR.user, user);

    }

}
