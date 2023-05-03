package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;

public class Dima {
    Wave WaveArray[]; // Array of wave objects
    int WaveAmount = 8; //Amount of waves
    int WaveSet = WaveAmount/2; //Chooses which wave to put the boats on

    Boat boats[], duckBoat; //the object for the boat and duck
    MyVisual mv;    //Myvisual class

    PShape duck, duck2; //Pshapes for loaded obj
    DuckVortex vortex;  
    DuckCircle duckCircle;

    public Dima(MyVisual mv){
        this.mv = mv;   //assigns mv to local mv

        int WaveHeightOffset = 50;  //sets wave ofset

        WaveArray = new Wave[WaveAmount];   //creates wave array
        for(int i = 0; i < WaveAmount; i++){    //
            WaveArray[i] = new Wave(mv, mv.width, mv.height/2 - (WaveHeightOffset * (-WaveAmount/2 + i)), 200);
        }

        boats = new Boat[3];
        boats[0] = new Boat(WaveArray[WaveSet], 200, 50, 0);

        for(int i = 1; i < boats.length; i++){
            boats[i] = new Boat(WaveArray[WaveSet], 200 * (i + 1), 100, 0, boats[0].GetPShape());
            boats[i].setStroke(255,255,255);
        }
        
        duck = mv.loadShape("duck.obj");

        duck.setFill(mv.color(40,255,255));
        //duck.setFill(false);
        //duck.setStroke(true);
        //duck.setStrokeWeight(0.02f);
        //duck.setStroke(mv.color(40,255,255));
        
        duck2 = mv.loadShape("duck.obj");
        duck2.setFill(mv.color(40,255,255));

        duckBoat = new Boat(WaveArray[WaveSet], mv.width*0.8f, 100, 50, duck);
        duckBoat.GetPShape().scale(30);
        duckBoat.GetPShape().rotateX(PApplet.PI/2f);
        //duckBoat.GetPShape().rotateY(-0.5f);
        duckBoat.GetPShape().scale(1,1,0.09f);

        vortex = new DuckVortex(mv, duck2);
        duckCircle = new DuckCircle(mv, duck2);
    }

    public void Visual(int VisIndex){

        mv.lights();

        switch(VisIndex){
            case 0:{
                
                

                mv.pushMatrix();
                mv.pushMatrix();
                for(int i = 0; i < WaveAmount; i++){
                    float Brightness = 255f*(float)(WaveAmount - i)/WaveAmount;
                    mv.stroke(120,255,Brightness);
                    
                    mv.strokeWeight(1);
                    mv.translate(0, 0, -10);

                    WaveArray[i].SetWave();
                    WaveArray[i].RenderWave((-i - 1)/2f);

                    mv.stroke(174,255,Brightness);
                    WaveArray[i].JoinWaveVerts((i - 1 < 0)?null: WaveArray[i-1]);

                }
                mv.popMatrix();

                mv.translate(0,0,-10 * (WaveSet + 1));    //makes Pshape render infront of wave

                for(Boat b: boats){
                    mv.stroke(255,255,255);
                    b.Render(0.05f,0.1f,1.5f);
                    b.ChangeX(-PApplet.sin(mv.millis()/1500f));
                }
                mv.translate(0,0,-9);
                duckBoat.Render(0.05f,0.1f,1.5f);
                duckBoat.ChangeX(PApplet.sin(mv.millis()/1500f));

                mv.popMatrix();
            }
            break;

            case 1:{
                mv.translate(5*mv.width/6,mv.height/2,0);

                mv.rotateX(2 * PApplet.PI/6.0f);
                
                mv.translate(0,0,-50);

                mv.scale(60);
                vortex.Render();
            }
            break;

            case 2:{

                mv.noFill();
                mv.stroke(255,0,0);
                mv.strokeWeight(10);

                mv.translate(mv.width/2,mv.height/2,0);
                mv.rotateX(2 * PApplet.PI/6.0f);
                
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
