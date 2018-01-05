package com.fc.buildermodle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Charactor charactor = new Charactor();
//        charactor.setClothes("军大衣");
//        charactor.setHeight(180);
//        charactor.setShoes("阿迪王");
//        charactor.setTrousers("短裤");
//        charactor.setWeapon(null);

        Charactor charactor = new Charactor.Builder()
                .clothes("军大衣")
                .height(180)
                .shoes("阿迪王")
                .trousers("短裤")
                .weapon(null)
                .build();
    }
}
