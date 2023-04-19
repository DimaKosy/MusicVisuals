package ie.tudublin;

import processing.core.PApplet;

public class MyVisual extends PApplet 
{
    Darren Dub;
    public void settings() 
    {
        //size(1980, 1080);
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {   
        colorMode(HSB);
        background(0);
        Dub = new Darren(this);
    }

    public void draw()
    {
        float r;
        r = random(10,50);
        fill(0,0,0,r);
        rect(0,0,width,height);
        Dub.render();
    }

    
}
