package com.ihongqiqu.databinding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Data Binding Samples");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                startDataBindingSampleActivity1();
                break;
            case R.id.button3:
                startDataBindingSampleActivity2();
                break;
            case R.id.button4:
                startDataBindingSampleActivity3();
                break;
        }
    }

    /**
     * 数据绑定
     */
    private void startDataBindingSampleActivity1() {
        Intent intent = new Intent(this, DataBindingSampleActivity1.class);
        startActivity(intent);
    }

    /**
     * 事件绑定
     */
    private void startDataBindingSampleActivity2() {
        Intent intent = new Intent(this, DataBindingSampleActivity2.class);
        startActivity(intent);
    }

    /**
     * 实时更新
     */
    private void startDataBindingSampleActivity3() {
        Intent intent = new Intent(this, DataBindingSampleActivity3.class);
        startActivity(intent);
    }

}
