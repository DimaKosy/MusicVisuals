package c21518659;

import example.MyVisual;
import java.util.ArrayList;

public class LyricLine
{
    MyVisual mv;
    ArrayList<Character> line = new ArrayList<Character>();
    int timestamp;

    public LyricLine(MyVisual mv, ArrayList<Character> line, int timestamp)
    {
        this.mv = mv;
        this.line = line;
        this.timestamp = timestamp;
    }
}