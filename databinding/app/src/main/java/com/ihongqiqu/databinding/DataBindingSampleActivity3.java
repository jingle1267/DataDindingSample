package com.ihongqiqu.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ihongqiqu.databinding.data.Pig;
import com.ihongqiqu.databinding.data.User;
import com.ihongqiqu.databinding.databinding.ActivityDataBindingSample2Binding;
import com.ihongqiqu.databinding.databinding.ActivityDataBindingSample3Binding;
import com.ihongqiqu.databinding.event.MyHandlers;
import com.ihongqiqu.databinding.event.PigHandler;

/**
 * 实时更新
 */
public class DataBindingSampleActivity3 extends AppCompatActivity {

    public Pig pig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("实时更新");

        pig = new Pig();
        pig.setLabel("ChangBaiShan");
        pig.setWeight("200Kg");
        PigHandler pigHandler = new PigHandler(this);

        ActivityDataBindingSample3Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding_sample3);
        binding.setPig(pig);
        binding.setPigHandler(pigHandler);
    }

}
