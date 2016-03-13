package com.ihongqiqu.databinding.event;

import android.view.View;
import com.ihongqiqu.databinding.DataBindingSampleActivity3;

/**
 * 事件处理
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class PigHandler {

    DataBindingSampleActivity3 sampleActivity3;

    public PigHandler(DataBindingSampleActivity3 sampleActivity3) {
        this.sampleActivity3 = sampleActivity3;
    }

    public void onClick(View view) {
        if (sampleActivity3 != null && sampleActivity3.pig != null) {
            sampleActivity3.pig.setLabel("长白山");
            sampleActivity3.pig.setWeight("280Kg");
        }
    }

}
