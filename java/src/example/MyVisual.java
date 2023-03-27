package example;

import ie.tudublin.*;

import c21376161.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;

    Dima dima;
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
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Moby Duck.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);

        dima = new Dima(this);
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
        //background(0, 30);
        fill(0,0,0,map(mouseX,0,width,0,256));
        translate(0,0,-1000);
        rect(-width,-height,4f*width,4f*height);
        translate(0,0,1000);
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
        fill(0,255,255,255);
        rect(i + 10,10,10,10);

        dima.Visual(1);

        
        i+= 20;
        i%=width;
    }
}
