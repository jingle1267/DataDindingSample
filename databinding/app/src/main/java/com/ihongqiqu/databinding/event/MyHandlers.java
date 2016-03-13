package com.ihongqiqu.databinding.event;

import android.view.View;
import android.widget.Toast;

/**
 * 时间处理
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class MyHandlers {

    public final void onClickName(View view) {
        Toast.makeText(view.getContext(), "onClickName()", Toast.LENGTH_SHORT).show();
    }

    public final void onClickAge(View view) {
        Toast.makeText(view.getContext(), "onClickAge()", Toast.LENGTH_SHORT).show();
    }
}
