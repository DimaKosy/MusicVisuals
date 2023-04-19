package c21376161;

import processing.core.PApplet;
import processing.core.PShape;

public class Boat extends Bobber {
    public PShape Hull, Mast;
    float drop = 0;

    public Boat(Wave wave, float pos, float length, float drop){
        super(wave, pos, length);
        this.drop = drop;

        Hull = p.createShape(PShape.GEOMETRY);
        Hull.beginShape();
        Hull.stroke(0,0,255);
        Hull.vertex(-50,-10);
        Hull.vertex(-48,-20);
        Hull.vertex(-20, -20);
        Hull.vertex(-20, -10);
        Hull.vertex(15, -10);
        Hull.vertex(30, -20);
        Hull.vertex(55, -20);

        Hull.vertex(69, -23);
        Hull.vertex(70, -22);

        Hull.vertex(55, -15);
        Hull.bezierVertex( 40,20, -20,10, -45, 7);

        //p.line(-50, -10, 50,-10);
        //p.line(-50, -10, -45,7);
        //p.bezier(-45, 7, -20,10, 50,20, 50,-10);
        Hull.endShape(PApplet.CLOSE);
        Hull.setFill(true);
        Hull.setFill(wave.mv.color(0,0,0));

        
    }

    public Boat(Wave wave, float pos, float length, float drop, PShape Hull){
        super(wave, pos, length);
        this.drop = drop;
        this.Hull = Hull;
    }

    public void Render(float AngleRate, float HeightRate,float scale){
        GetAngle(AngleRate, HeightRate);
        p.translate(pos + length/2, LerpedMidHeight + drop);
        p.rotate(LerpedAngle);
        p.scale(scale);

        //drawing
        p.stroke(0,0,255);
        p.strokeWeight(1);
        p.noFill();

        //sail and mast
        p.rect(-1.5f,-10,3,-70);
        p.bezier(-10,-80,20,-70, 20,-25,-10,-15);
        //hull
        p.shape(Hull);

        p.scale(1/scale);
        //drawing
        p.rotate(-LerpedAngle);
        p.translate(-(pos + length/2), -LerpedMidHeight - drop);
    }
}
