package c21518659;

import example.MyVisual;

public class LyricLine
{
    MyVisual mv;
    String line;
    int timestamp;

    public LyricLine(MyVisual mv, String line, int timestamp)
    {
        this.mv = mv;
        this.line = line;
        this.timestamp = timestamp;
    }
}