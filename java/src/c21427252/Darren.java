package c21427252;

import example.MyVisual;

public class Darren 
{
    private MyVisual mv;
    private bubbles b;
    
    public Darren(MyVisual myVisual )
    {
        this.mv = myVisual;
        b = new bubbles(myVisual.width,myVisual.height, myVisual);
    }

    public void render()
    {
        b.render();
    }
}
