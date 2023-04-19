package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;

public class SuperDuck {

    protected PShape Duck;
    protected MyVisual mv;
    protected float Rotator;

    public SuperDuck(MyVisual mv, PShape Duck){
        this.mv = mv;
        this.Duck = Duck;
        Rotator = 0;
    }
    
    void Ring(int Amnt, float Radius, float Rot, boolean DuckSpin){
        mv.rotate(Rotator * Rot);
        mv.pushMatrix();
        mv.pushStyle();
        mv.scale(0.3f);
        for(int i = 0; i < Amnt; i++){
            mv.rotate((PApplet.TWO_PI/(float)Amnt));

            mv.pushMatrix();
            mv.translate(Radius,0);

            if(DuckSpin){
                mv.rotate(Rotator + i, 1,1,1);
            }
            mv.shape(Duck);
            //mv.rotate(-Rotator - i, 1,1,1);

            //mv.translate(-Radius,0);
            mv.popMatrix();
        }

        mv.popStyle();
        mv.popMatrix();
    }

    void Ring(PShape Ducks[], float Scaler[],int Amnt, float Radius, float Rot, boolean DuckSpin){
        mv.rotate(Rotator * Rot);
        mv.pushMatrix();
        mv.pushStyle();
        mv.scale(0.3f);
        for(int i = 0; i < Amnt; i++){
            mv.rotate((PApplet.TWO_PI/(float)Amnt));

            mv.pushMatrix();
            mv.translate(Radius,0);
            mv.scale(Scaler[i%Scaler.length]);
            if(DuckSpin){
                mv.rotate(Rotator + i, 1,1,1);
            }
            mv.shape(Ducks[i%Ducks.length]);
            //mv.rotate(-Rotator - i, 1,1,1);

            //mv.translate(-Radius,0);
            mv.popMatrix();
        }

        mv.popStyle();
        mv.popMatrix();
    }
}
