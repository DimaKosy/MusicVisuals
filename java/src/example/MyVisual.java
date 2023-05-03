package example;

import ie.tudublin.*;
import c21376161.*;
import c21321073.DM_Project2;
import c21344786.*;
import c21518659.*;
import c21427252.*;

public class MyVisual extends Visual
{
    float position;
    Dima dima;
    Norbert norbert;
    Shawn shawn;
    Darren darren;
    DM_Project2 domas;

    public void settings()
    {
        fullScreen(P3D, SPAN); 
        smooth();
    }

    public void setup()
    {
        
        colorMode(HSB);
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("MobyDuck.wav");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 

        dima = new Dima(this);
        norbert = new Norbert(this);
        dima = new Dima(this);
        shawn = new Shawn(this);
        darren = new Darren(this);
        domas = new DM_Project2(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 
        //
        //// Call this is you want to get the average amplitude
        calculateAverageAmplitude();        

        position = map(getAudioPlayer().position(), 0, getAudioPlayer().length(), 0, 100);
        //position = 70;
        background(0);

        if(position <= 20){
            background(0);
            norbert.visual();   
        }
        if(position >= 20 && position <= 30){
            dima.Visual(2);
        }
        if(position >= 30 && position <= 40){    
            dima.Visual(0); 
        }
        if(position >= 40 && position <= 60){
            colorMode(RGB);
            shawn.visual();
        }
        if(position >= 60 && position <= 80){
            float r;
            r = random(20, 50);
            fill(0,0,0,r);
            rect(0, 0, width, height);
            darren.render();
        }
        if(position >= 80 && position <= 100){
            domas.visual();
        }

        
    }
}
