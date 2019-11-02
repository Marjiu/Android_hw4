package com.example.android_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText mileage_in;                //宣告全域變數

    EditText addition_in;                //宣告全域變數

    EditText amount_in;                 //宣告全域變數

    TextView amount_out;                //宣告全域變數

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        mileage_in = (EditText)findViewById(R.id.mileage_in);       // 取得里程物件

        addition_in = (EditText)findViewById(R.id.addition_in);     // 取得每幾公尺物件

        amount_in = (EditText)findViewById(R.id.amount_in);      // 取得加成金額物件

        amount_out= (TextView) findViewById(R.id.amount_out);       // 取得顯示物件

        Button submit = (Button)findViewById(R.id.output);             // 取得按鈕物件

        submit.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View arg0) {



                float fresult_out = Float.parseFloat(mileage_in.getEditableText().toString());      // 取得  里程輸入值

                float addition = Float.parseFloat(addition_in.getEditableText().toString());      // 取得 加成輸入值

                float amount = Float.parseFloat(amount_in.getEditableText().toString());      // 取得 加成金額輸入值




                if (fresult_out <=addition) {
                    fresult_out=amount+75;

                    amount_out.setText("費用:"+   fresult_out+"元");           // 顯示計算結果

                }

                else  if (fresult_out > addition) {


                    TextView result = (TextView)findViewById(R.id.amount_out);// 取得 顯示結果 物件

                    fresult_out = (float) Math.ceil(fresult_out/addition)*amount+75;    //計算

                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式

                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位

                    result.setText("費用:"+nf.format(fresult_out) +"元");           // 顯示計算結果







                }



            }

        });

    }

}