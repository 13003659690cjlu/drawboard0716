package com.example.drawboard0716;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myView;


    private Button circleBtn;
    private Button freeLineBtn;
    private SeekBar seekBarStoke;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView =findViewById(R.id.draw);

        circleBtn=findViewById(R.id.circleBtn);
        circleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setFigureType("circle");
            }
        });

        freeLineBtn =findViewById(R.id.freeLineBtn);
        freeLineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setFigureType("freeLine");
            }
        });

        seekBarStoke = findViewById(R.id.strokeBtn);
        seekBarStoke.setMax(100);
        seekBarStoke.setProgress(20);

        seekBarStoke.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 进度值改变时的逻辑处理
                myView.getP().setStrokeWidth(seekBarStoke.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // 用户开始拖动滑块时的逻辑处理
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 用户停止拖动滑块时的逻辑处理
            }
        });




        // 在这里可以执行其他初始化操作
    }

    public void drawLine(View view) {
        // 在这里处理点击 "Line" 按钮事件
    }

    public void drawFreehand(View view) {
        // 在这里处理点击 "Freehand" 按钮事件
    }
}