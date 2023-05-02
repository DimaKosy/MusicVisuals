package c21518659;

import example.MyVisual;
import processing.core.PApplet;

import java.util.ArrayList;


public class Norbert
{
    MyVisual mv;
    ArrayList<LyricLine> lyrics;
    String[] lines;
    float amp;

    public Norbert(MyVisual mv)
    {
        this.mv = mv;
        lyrics = new ArrayList<LyricLine>();
        lines = mv.loadStrings("MobyDuck.txt");
        for(int i = 0; i < lines.length; i++)
        {
            String[] words = PApplet.split(lines[i], " ");
            int timestamp = Integer.parseInt(words[0]);

            ArrayList<Character> line = new ArrayList<Character>();

            for(int j = 1; j < words.length; j++)
            {
                String word = words[j];

                for(int k = 0; k < word.length(); k++)
                {
                    char c = word.charAt(k);
                    line.add(new Character(mv, c, mv.width + mv.textWidth(c ), mv.height / 2)); 
                }

                line.add(new Character(mv, ' ', mv.width, mv.height / 2));
            }

            lyrics.add(new LyricLine(mv, line, timestamp));
        }
    }

    public void visual()
    {
        for(int i = 0; i < lyrics.size(); i++)
        {
            LyricLine lyricLine = lyrics.get(i);

            if(mv.getAudioPlayer().position() >= lyricLine.timestamp)
            {
                amp = mv.getSmoothedAmplitude() * 300;
            
                for(int j = 0; j < lyricLine.line.size(); j++)
                {
                    Character c = lyricLine.line.get(j);
                    
                    if(j > 0)
                    {
                        Character prev = lyricLine.line.get(j - 1);
                        c.x = prev.x + mv.textWidth(prev.c) * 1.3f;
                    }
                    
                    c.x -= 6.0f;
                    mv.fill(255);
                    mv.textSize(32);
                    mv.text(c.c, c.x, c.y + PApplet.sin(PApplet.radians(c.x)) * amp);

                }
            }
        }
        
    }
    
}
