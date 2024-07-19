package com.example.drawboard0716;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

public class MyView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {
    private Paint p = new Paint();
    ;
    private Path path = new Path();


    private String figureType = "freeLine";


    private FigureNode head;
    private FigureNode current;
    private int nodeCount = 0;
    boolean flag = false;


    public String getFigureType() {
        return figureType;
    }

    public void setFigureType(String figureType) {
        this.figureType = figureType;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Paint getP() {
        return p;
    }

    public void setP(Paint p) {
        this.p = p;
    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }

    public void setCurrentFigure(Figure currentFigure) {
        this.currentFigure = currentFigure;
    }

    private Figure currentFigure = new FreeLine();


    public MyView(Context context, AttributeSet attrs) {

        super(context, attrs);
        getHolder().addCallback(this);
        head=new FigureNode();
        current=head;

        p.setColor(Color.RED);//默认值
        p.setTextSize(20);//默认值
        p.setStrokeWidth(20);
        p.setStyle(Paint.Style.FILL.STROKE);//默认值

        setOnTouchListener(this);

    }

    public void draw() {

        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        //canvas.drawPath(path,p);
        //canvas.drawLine();
//        currentFigure.setPaint(p);


        FigureNode throughNode = head;
        for (int i = 0; i < nodeCount; i++) {
            throughNode = throughNode.getNextNode();
            throughNode.getFigure().drwaFigure(canvas);
        }


        if (currentFigure != null&&flag) {
            currentFigure.drwaFigure(canvas);
        }


        //canvas.drawLine(currentFigure.getStart().x,currentFigure.getStart().y,currentFigure.getEnd().x,currentFigure.getEnd().y,currentFigure.getPaint());
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        draw();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    public FigureNode getHead() {
        return head;
    }

    public void setHead(FigureNode head) {
        this.head = head;
    }

    public FigureNode getCurrent() {
        return current;
    }

    public void setCurrent(FigureNode current) {
        this.current = current;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://按下屏幕执行的动作
            {
                this.setFlag(true);
                switch (this.getFigureType()) {

                    case ("circle"): {
                        System.out.println("circle");
                        setCurrentFigure(new Circle());
                        break;
                    }
                    case ("line"):{
                        setCurrentFigure(new Line());
                        break;
                    }
                    case ("rect"):{
                        setCurrentFigure(new Rectangle());
                        break;
                    }
                    default:
                    {
                        setCurrentFigure(new FreeLine());
                        break;
                    }
                }
                this.getCurrentFigure().setStart(new Point((int) event.getX(), (int) event.getY()));
                this.getCurrentFigure().setPaint(new Paint(this.getP()));

                if ("freeLine".equals(this.getFigureType())) {

                    FreeLine freeLine = (FreeLine) currentFigure;
                    freeLine.setPath(new Path());
                    freeLine.getPath().moveTo(event.getX(), event.getY());
                }

                  currentFigure.setStart(new Point((int) event.getX(), (int) event.getY()));
                  currentFigure.setEnd(new Point((int) event.getX(), (int) event.getY()));
//                this.setCurrentFigure(new FreeLine());
//                path.moveTo(event.getX(), event.getY());
//                FreeLine freeLine= (FreeLine) this.getCurrentFigure();
//                freeLine.setPath(this.getPath());
                //currentFigure.setStart(new Point((int)event.getX(),(int)event.getY()));
                draw();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                //path.lineTo(event.getX(),event.getY());
                //currentFigure.setEnd(new Point((int)event.getX(),(int)event.getY()));
                if ("freeLine".equals(this.getFigureType())) {
                    FreeLine freeLine = (FreeLine) currentFigure;
                    freeLine.getPath().lineTo(event.getX(), event.getY());
                }
                else
                {
                    currentFigure.getEnd().x= (int) event.getX();
                    currentFigure.getEnd().y= (int) event.getY();
                }

                draw();
                break;
            }
            case  MotionEvent.ACTION_UP:
            {
                this.setFlag(false);
                nodeCount++;
                FigureNode newNode = new FigureNode(currentFigure);
                if(current==null)
                {
                    System.out.println("current==null");
                }
                current.setNextNode(newNode);
                newNode.setLastNode(current);
                current=current.getNextNode();
            }

        }
        //invalidate();
        return true;
    }
}
