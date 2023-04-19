package ie.tudublin;

import processing.core.PApplet;

public class Darren 
{
    private MyVisual mv;
    private bubbles b;
    
    public Darren(MyVisual mv )
    {
        this.mv = mv;
        b = new bubbles(mv.width,mv.height, mv);
    }

    public void render()
    {
        b.render();
    }
}
