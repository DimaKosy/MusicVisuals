package c21376161;

import processing.core.PApplet;

public class Bobber {
    Wave wave;
    float Angle = 0;
    float LerpedAngle = 0;
    float LowHeight, MidHeight, HighHeight;
    float LerpedLowHeight = 0, LerpedMidHeight = 0, LerpedHighHeight = 0;
    float pos;
    float length;

    public boolean Debug = false;

    PApplet p;

    public Bobber(Wave wave, float pos, float length){
        this.wave = wave;
        this.pos = pos;
        this.length = length;
        this.p = wave.mv;
    }

    public void GetAngle(float AngleRate, float HeightRate){
        Angle = (float)PApplet.atan((wave.GrabWavePoint(pos + length) - wave.GrabWavePoint(pos))/(length));
        LerpedAngle = PApplet.lerp(LerpedAngle, Angle, AngleRate);
        MidHeight = (wave.GrabWavePoint(pos + length)+wave.GrabWavePoint(pos))/2;


        LerpedMidHeight = PApplet.lerp(LerpedMidHeight, MidHeight, HeightRate);

        if(wave.GrabWavePoint(pos + length) > wave.GrabWavePoint(pos)){
            HighHeight = wave.GrabWavePoint(pos + length);
            LowHeight = wave.GrabWavePoint(pos);
        }
        else{
            HighHeight = wave.GrabWavePoint(pos);
            LowHeight = wave.GrabWavePoint(pos + length);
        }

        LerpedHighHeight = PApplet.lerp(LerpedHighHeight, HighHeight, HeightRate);
        LerpedLowHeight = PApplet.lerp(LerpedLowHeight, LowHeight, HeightRate);

        if(!Debug){
            return;
        }

        int preCol = p.g.strokeColor;
        float preWeight = p.g.strokeWeight;

        p.stroke(0,0,255);
        p.strokeWeight(1);
        p.translate(pos + length/2, wave.WaveHeight + 100);

        p.line(-length/2, -20, -length/2, 20);

        p.line(-length/2,0, length/2, 0);
        
        p.line(length/2, -20, length/2, 20);

        p.rotate(LerpedAngle);
        p.stroke(255,255,255);
        p.strokeWeight(3);
        p.line(0.9f*(-length/2), -0, 0.9f*(length/2), 0);
        p.rotate(-LerpedAngle);
        
        p.translate(-pos - length/2, -wave.WaveHeight - 100);

        p.stroke(preCol);
        p.strokeWeight(preWeight);
    }
}