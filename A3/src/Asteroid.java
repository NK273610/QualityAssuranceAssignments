public class Asteroid
        extends BoardComponent
{
    private int height;

    public Asteroid(int paramInt)
    {
        height = paramInt;
    }





    public void Operation()
    {
        height -= 1;
        if (0 == height)
        {




            GameBoard.Instance().GetSub().notifyAllObservers(event.ASTEROID_ATTACK, (Square)parent);



            parent.Remove(this);
        }
    }

    public void Add(BoardComponent paramBoardComponent) {}

    public void Remove(BoardComponent paramBoardComponent) {}
}