package com.example.drawboard0716;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class Line extends Figure {

    public Line() {
    }


    @Override
    public void drwaFigure(Canvas canvas) {
        canvas.drawLine(this.getStart().x,this.getStart().y,this.getEnd().x,this.getEnd().y,this.getPaint());
    }
}
