package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;

public class Dima {
    Wave MainWave, Wave2, Wave3;
    Boat boat, boat1, boat2, duckBoat;
    MyVisual mv;

    float rot = 0;
    PShape duck;
    DuckVortex vortex;
    DuckCircle duckCircle;

    public Dima(MyVisual mv){
        this.mv = mv;
        MainWave =  new Wave(this.mv, mv.width, mv.height/2, 200);
        Wave2 =     new Wave(this.mv, mv.width, mv.height/2 - 10, 200);
        Wave3 =     new Wave(this.mv, mv.width, mv.height/2 + 10, 200);


        boat = new Boat(MainWave, 125, 50, 0);
        boat1 = new Boat(MainWave, 300, 100, 0,boat.Hull);
        boat2 = new Boat(MainWave, 500, 100, 0,boat.Hull);
        boat.Debug = true;
        boat1.Debug = true;
        boat2.Debug = true;
        
        duck = mv.loadShape("duck.obj");
        duck.setFill(mv.color(40,255,255));

        duckBoat = new Boat(MainWave, mv.width*0.9f, 100, 0, duck);

        vortex = new DuckVortex(mv, duck);
        duckCircle = new DuckCircle(mv, duck);
    }

    public void Visual(int VisIndex){
        switch(VisIndex){
            case 0:{
                mv.lights();
                mv.background(0);
                mv.stroke(255);
                MainWave.SetWave();
                

                Wave2.SetWave();
                Wave2.RenderWave(-2f);

                Wave3.SetWave();

                mv.translate(0,0,1);    //makes Pshape render infront of wave
                boat.Render(0.05f,0.4f,1.5f);
                boat1.Render(0.05f,0.7f,1.5f);
                boat2.Render(0.05f,0.1f,1.5f);
                duckBoat.Render(0.05f,0.1f,1.5f);

                mv.push();
                mv.scale(50);
                mv.shape(duck);

                mv.pop();
                MainWave.RenderWave(-3f);
                Wave3.RenderWave(-4f);
                mv.translate(0,0,-1);
                MainWave.JoinWaveVerts(MainWave,Wave2);
            }
            break;

            case 1:{
                mv.lights();
                mv.translate(5*mv.width/6,mv.height/2,0);
                //mv.rotateX(PApplet.PI/2.0f);
                //mv.rotateX(-PApplet.PI/6.0f);

                mv.rotateX(2 * PApplet.PI/6.0f);
                //mv.rotateY(rot);
                //mv.rotateZ(rot);
                rot+= 0.01f;
                mv.translate(0,0,-50);

                mv.scale(60);
                vortex.Render();
            }
            break;

            case 2:{
                mv.background(0);
                mv.lights();
                mv.translate(mv.width/2,mv.height/2,0);
                //mv.fill(255,255,255);
                mv.noFill();
                mv.stroke(255,0,0);
                mv.strokeWeight(10);
                mv.rotateX(2 * PApplet.PI/6.0f);
                //mv.rotateY(rot);
                //mv.rotateZ(rot);
                rot+= 0.01f;
                mv.translate(0,0,-50);

                mv.scale(60);
                duckCircle.Render();
            }
            break;

            default:
            break;
        }
    }
}
