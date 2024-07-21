package com.example.drawboard0716;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.jaredrummler.android.colorpicker.ColorPickerView;


public class MainActivity extends AppCompatActivity {

    private MyView myView;


    private Button circleBtn;
    private Button freeLineBtn;
    private Button lineBtn;
    private Button recBtn;


    private Button backBtn;
    private Button nextBtn;


    private Button colorBtn;

    private SeekBar seekBarStoke;
    private SeekBar lucencyBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView =findViewById(R.id.draw);


        backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nodeCount = myView.getNodeCount();
                if(nodeCount >0)
                {
                    nodeCount--;
                    myView.setCurrent(myView.getCurrent().getLastNode());
                    myView.setNodeCount(nodeCount);
                    //myCanvas.paint(frame.getGraphics());
                    myView.draw();
                }
            }
        });

        nextBtn=findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FigureNode currentNode = myView.getCurrent();
                if(currentNode.getNextNode()!=null)
                {
                    myView.setCurrent(currentNode.getNextNode());
                    int nodeCount = myView.getNodeCount();
                    nodeCount++;
                    myView.setNodeCount(nodeCount);
                    myView.draw();
                }
            }
        });

        colorBtn =findViewById(R.id.colorBtn);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int initialColor = Color.RED;

                // 创建颜色选择器对话框
                AlertDialog.Builder colorPickerDialog = new AlertDialog.Builder(MainActivity.this);
                colorPickerDialog.setTitle("选择颜色");
                colorPickerDialog.setCancelable(true);

                // 设置颜色选择器视图
                ColorPickerView colorPickerView = new ColorPickerView(MainActivity.this);
                colorPickerView.setColor(initialColor);
                colorPickerDialog.setView(colorPickerView);

                // 设置确定按钮
                colorPickerDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int selectedColor = colorPickerView.getColor();
                        myView.getP().setColor(selectedColor);
                        // 在这里处理选中的颜色
                        // 可以将选中的颜色应用到视图或执行其他操作
                    }
                });

                // 设置取消按钮
                colorPickerDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                // 显示颜色选择器对话框
                colorPickerDialog.show();
            }
        });






        circleBtn=findViewById(R.id.circleBtn);
        circleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setFigureType("circle");
            }
        });

        lineBtn=findViewById(R.id.lineBtn);
        lineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setFigureType("line");
            }
        });


        freeLineBtn =findViewById(R.id.freeLineBtn);
        freeLineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setFigureType("freeLine");
            }
        });

        recBtn =findViewById(R.id.recBtn);
        recBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setFigureType("rect");
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


        lucencyBtn = findViewById(R.id.lucencyBtn);
        lucencyBtn.setMax(255);
        lucencyBtn.setProgress(255);

        lucencyBtn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 进度值改变时的逻辑处理
                myView.getP().setAlpha(lucencyBtn.getProgress());
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