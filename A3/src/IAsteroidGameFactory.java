import java.util.ArrayList;

public abstract interface IAsteroidGameFactory
{
    public abstract BoardComponent MakeSquare();

    public abstract BoardComponent MakeBuilding();

    public abstract Asteroid MakeAsteroid(int paramInt);

    public abstract ArrayList<ArrayList<BoardComponent>> MakeBoard(int paramInt1, int paramInt2);

    public abstract Command MakeCommand(String paramString);
}