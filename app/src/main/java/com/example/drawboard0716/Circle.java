package com.example.drawboard0716;

import android.graphics.Canvas;
import android.graphics.Point;

public class Circle extends Figure{

    public Circle() {
    }

    @Override
    public void drwaFigure(Canvas canvas) {
        canvas.drawCircle(this.getStart().x,this.getStart().y,getDistance(this.getStart(),this.getEnd()),this.getPaint());
    }

    public float getDistance(Point p1,Point p2)
    {
        float x1= p1.x- p2.x;
        float y1=p1.y-p2.y;
        return (float) Math.sqrt(x1*x1+y1*y1);
    }
}
