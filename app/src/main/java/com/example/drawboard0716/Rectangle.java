package com.example.drawboard0716;

import android.graphics.Canvas;

public class Rectangle extends Figure
{
    public Rectangle() {
    }

    @Override
    public void drwaFigure(Canvas canvas) {
        //canvas.drawRect(Math.min(this.getStart().x,this.getEnd().x),Math.min(this.getStart().x,this.getEnd().x));
        canvas.drawRect(this.getStart().x,this.getStart().y,this.getEnd().x,this.getEnd().y,this.getPaint());
    }
}
