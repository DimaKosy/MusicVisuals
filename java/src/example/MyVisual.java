package example;

import ie.tudublin.*;
import c21376161.*;
import c21344786.*;
import c21427252.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;

    float position;
    Dima dima;
    Darren darren;
    int i = 0;

    public void settings()
    {
        //size(1024, 500,P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN); 
        smooth();
    }

    public void setup()
    {
        
        colorMode(HSB);
        startMinim();
        background(0);
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Moby Duck.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);

        dima = new Dima(this);
        darren = new Darren(this);
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
        background(0, 30);
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
        //wf.render();
        //abv.render();
        //fill(0,255,255,255);
        //rect(i + 10,10,10,10);
        //position = map(getAudioPlayer().position(), 0, getAudioPlayer().length(), 0, 100);
        /* 
         * if(position < 10){
            dima.Visual(0);
        }
        else if(position < 20){
            dima.Visual(1);
        }
        else{
            dima.Visual(2);
        }
        */
        float r;
        r = random(20, 50);
        fill(0,0,0,r);
        rect(0, 0, width, height);
        darren.render();

        
        

        i+= 20;
        i%=width;
    }
}
