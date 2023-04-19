package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;

public class DuckVortex extends SuperDuck{

    public DuckVortex(MyVisual mv, PShape Duck){
        super(mv,Duck);
    }

    public void Render(){
        mv.pushMatrix();
        mv.shape(Duck);
        //mv.rotate(Rotator,0,0,0.1f);
        Rotator+= 0.01f;
        //Rotator %= PApplet.TWO_PI;
        Ring(10,10,1,true);
        mv.rotateY(PApplet.sin(Rotator)*0.5f);
        Ring(14,20,1.5f,true);
        mv.rotateY(PApplet.sin(2.1f*Rotator)*0.5f);
        Ring(24,30,1.6f,true);

        mv.popMatrix();
    }

}
