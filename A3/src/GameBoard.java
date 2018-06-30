import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameBoard
{
    private static GameBoard instance = null;

    private ArrayList<ArrayList<BoardComponent>> board;

    private final IAsteroidGameFactory factory;
    private int buildingCount;
    private IState gameState;
    private final ISubjectAsteroidImapacts sub;
    private final ISubjectAsteroidImapacts shieldedSub;

    public static GameBoard Instance()
    {
        if (null == instance)
        {
            instance = new GameBoard();
        }
        return instance;
    }





    private GameBoard()
    {
        board = null;
        factory = new AsteroidGameFactory();
        buildingCount = 0;
        gameState = new SetupState();
        sub = new SubjectAsteroidImpact();
        shieldedSub = new SubjectPassiveAsteroidImpact();
    }

    public ArrayList<ArrayList<BoardComponent>> GetBoard()
    {
        return board;
    }

    public void SetBoard(ArrayList<ArrayList<BoardComponent>> paramArrayList)
    {
        board = paramArrayList;
    }

    public IAsteroidGameFactory GetFactory()
    {
        return factory;
    }

    public ISubjectAsteroidImapacts GetSub()
    {
        return sub;
    }

    public ISubjectAsteroidImapacts GetShieldedSub()
    {
        return shieldedSub;
    }







    public void ProcessCommands(String paramString)
    {
        try
        {
            List localList = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(paramString, new String[0]));
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
                String str = (String)localIterator.next();
                Command localCommand = factory.MakeCommand(str);
                if (localCommand != null)
                {
                    localCommand.Execute();
                }


                if (gameState.IsGameOver())
                {

                    System.out.println("GAME OVER!!");
                    break;
                }
            }
        }
        catch (IOException localIOException)
        {
            System.out.println("Failed to parse command file: " + localIOException.getMessage());
        }
    }



    public void DoTick()
    {
        for (int i = 0; i < board.size(); i++)
        {
            ArrayList localArrayList = (ArrayList)board.get(i);
            for (int j = 0; j < localArrayList.size(); j++)
            {
                BoardComponent localBoardComponent = (BoardComponent)localArrayList.get(j);
                localBoardComponent.Operation();
            }
        }
    }


    public void IncrementBuildingCount()
    {
        buildingCount += 1;
    }


    public void DecrementBuildingCount()
    {
        buildingCount -= 1;
    }

    public int GetBuildingCount()
    {
        return buildingCount;
    }


    public void StartGame()
    {
        gameState = new GameState();
    }
}