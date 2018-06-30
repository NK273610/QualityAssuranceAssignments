import java.io.PrintStream;

public class SpawnBuildingCommad extends Command {
    public SpawnBuildingCommad(Object paramObject, String[] paramArrayOfString) {
        super(paramObject, paramArrayOfString);
    }

    public void Execute()
    {
        Square localSquare = (Square)receiver;



        IAsteroidGameFactory localIAsteroidGameFactory = GameBoard.Instance().GetFactory();
        GameBoard.Instance().IncrementBuildingCount();
        System.out.println("Spawning building at (" + args[0] + "," + args[1] + ") with total count = " + GameBoard.Instance().GetBuildingCount());

        Building localBuilding = (Building)localIAsteroidGameFactory.MakeBuilding();
        GameBoard.Instance().GetSub().attach(localBuilding);
        localSquare.Add(localBuilding);
    }
}