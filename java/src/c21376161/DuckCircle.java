package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class DuckCircle extends SuperDuck{
    PShape Ducks[];
    float DuckScaler[], lerpedDuckScaler[];
    int DuckAmt;

    public DuckCircle(MyVisual mv, PShape Duck){
        super(mv, Duck);

        this.DuckAmt = mv.getBands().length;

        Ducks = new PShape[DuckAmt];
        DuckScaler = new float[DuckAmt];
        lerpedDuckScaler = new float[DuckAmt];

        for(int i = 0; i < DuckAmt; i++){
            Ducks[i] = mv.loadShape("duck.obj");
            Ducks[i].setFill(mv.color(256f * ((float)i/(DuckAmt+1f)),255,255));
            DuckScaler[i] = 0.2f*i;
        }
    }
    
    public void Render(){
        mv.push();
        mv.pushMatrix();

        mv.rotate(Rotator);
        mv.shape(Duck);

        mv.popMatrix();
        
        for(int i = 0; i < DuckScaler.length; i++){
            DuckScaler[i] = PApplet.map(mv.getSmoothedBands()[i],0,200,0.5f,3);
        }

        Ring(Ducks, DuckScaler,DuckAmt, 30, -0.7f, false);

        mv.pop();
        Rotator += 0.01f;
    }
}
