import java.util.ArrayList;

public class AsteroidGameFactory
        implements IAsteroidGameFactory
{
    public AsteroidGameFactory() {}

    public BoardComponent MakeSquare()
    {
        return new Square();
    }


    public BoardComponent MakeBuilding()
    {
        Building localBuilding = new Building();
        return localBuilding;
    }


    public Asteroid MakeAsteroid(int paramInt)
    {
        Asteroid localAsteroid = new Asteroid(paramInt);
        return localAsteroid;
    }


    public ArrayList<ArrayList<BoardComponent>> MakeBoard(int paramInt1, int paramInt2)
    {
        ArrayList localArrayList1 = new ArrayList();
        for (int i = 0; i < paramInt1; i++)
        {

            ArrayList localArrayList2 = new ArrayList();

            for (int j = 0; j < paramInt2; j++)
            {
                localArrayList2.add(MakeSquare());
            }
            localArrayList1.add(localArrayList2);
        }
        return localArrayList1;
    }



    public Command MakeCommand(String paramString)
    {
        String[] arrayOfString = null;
        String str2 = "";
        String str1; if (paramString.contains(" "))
    {
        str1 = paramString.split(" ")[0];
        str2 = paramString.substring(str1.length() + 1);
        arrayOfString = str2.split(" ");
    }
    else
    {
        str1 = paramString; }
        int j;
        int k; BoardComponent localBoardComponent; switch (str1.toUpperCase())
    {

        case "INIT":
            return new InitializeBoardCommand(GameBoard.Instance(), arrayOfString);


        case "SPAWN_ASTEROID":
            j = Integer.parseInt(arrayOfString[0]);
            k = Integer.parseInt(arrayOfString[1]);
            localBoardComponent = (BoardComponent)((ArrayList)GameBoard.Instance().GetBoard().get(j)).get(k);
            return new SpawnAsteroidCommand(localBoardComponent, arrayOfString);


        case "TICK":
            return new TickCommand(GameBoard.Instance(), arrayOfString);


        case "START_GAME":
            return new StartGameCommand(GameBoard.Instance(), arrayOfString);





        case "SPAWN_BUILDING":
            j = Integer.parseInt(arrayOfString[0]);
            k = Integer.parseInt(arrayOfString[1]);
            localBoardComponent = (BoardComponent)((ArrayList)GameBoard.Instance().GetBoard().get(j)).get(k);
            return new SpawnBuildingCommad(localBoardComponent, arrayOfString);











        case "SPAWN_SHIELD":
            j = Integer.parseInt(arrayOfString[0]);
            k = Integer.parseInt(arrayOfString[1]);
            localBoardComponent = (BoardComponent)((ArrayList)GameBoard.Instance().GetBoard().get(j)).get(k);
            return new SpawnSheildCommand(localBoardComponent, arrayOfString);
    }

        return null;
    }
}
