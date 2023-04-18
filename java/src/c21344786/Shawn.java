package c21344786;

import example.MyVisual;

public class Shawn
{
    MyVisual mv;

    Board board1;
    Board board2;

    Sonar sonar1;
    Sonar sonar2;

    Radar radar1;

    public Shawn(MyVisual mv)
    {
        this.mv = mv;

        board1 = new Board(mv);
        board2 = new Board(mv);

        sonar1 = new Sonar(mv);
        sonar2 = new Sonar(mv);

        radar1 = new Radar(mv);
    }

    public void visual(int index)
    {
        switch(index)
        {
            case 0:
            {}
            break;
        }
    }
}
