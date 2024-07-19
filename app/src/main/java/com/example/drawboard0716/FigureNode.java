package com.example.drawboard0716;

public class FigureNode
{
    private Figure figure;
    private FigureNode lastNode;
    private FigureNode nextNode;

    public FigureNode()
    {
    }

    public FigureNode(Figure figure)
    {
        this.figure = figure;
    }

    public Figure getFigure()
    {
        return figure;
    }

    public void setFigure(Figure figure)
    {
        this.figure = figure;
    }

    public FigureNode getLastNode()
    {
        return lastNode;
    }

    public void setLastNode(FigureNode lastNode)
    {
        this.lastNode = lastNode;
    }

    public FigureNode getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(FigureNode nextNode)
    {
        this.nextNode = nextNode;
    }
}
