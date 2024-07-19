package com.example.drawboard0716;

import android.graphics.Canvas;

import android.graphics.Paint;
import android.graphics.Path;

public class FreeLine extends Figure
{

    private Path path=new Path();
    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public FreeLine() {

    }

    @Override
    public void drwaFigure(Canvas canvas) {
        if(this.getPath()==null)
        {
            //System.out.println("error");
        }
            canvas.drawPath(this.getPath(),this.getPaint());
    }
}
