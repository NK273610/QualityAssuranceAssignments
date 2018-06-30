import java.io.PrintStream;

public class SpawnAsteroidCommand extends Command {
    public SpawnAsteroidCommand(Object paramObject, String[] paramArrayOfString) {
        super(paramObject, paramArrayOfString);
    }



    public void Execute()
    {
        BoardComponent localBoardComponent = (BoardComponent)receiver;


        int i = Integer.parseInt(args[2]);
        IAsteroidGameFactory localIAsteroidGameFactory = GameBoard.Instance().GetFactory();
        System.out.println("Spawning asteroid at (" + args[0] + "," + args[1] + ") with height = " + i);
        localBoardComponent.Add(localIAsteroidGameFactory.MakeAsteroid(i));
    }
}