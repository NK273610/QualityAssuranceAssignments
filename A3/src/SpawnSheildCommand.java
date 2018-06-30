import java.util.ArrayList;

public class SpawnSheildCommand extends Command
{
    public SpawnSheildCommand(Object paramObject, String[] paramArrayOfString)
    {
        super(paramObject, paramArrayOfString);
    }






    public void Execute()
    {
        IAsteroidGameFactory localIAsteroidGameFactory = GameBoard.Instance().GetFactory();
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        ArrayList localArrayList = GameBoard.Instance().GetBoard();
        BoardComponent localBoardComponent = (BoardComponent)receiver;
        Shield localShield = new Shield(localBoardComponent, i, j);
        ((ArrayList)localArrayList.get(i)).set(j, localShield);

        GameBoard.Instance().GetSub().notifyAllObservers(event.SHIELD_ADDED, localBoardComponent);
        GameBoard.Instance().GetSub().attach((IObserver)localShield);

        System.out.println("Spawning sheild at (" + args[0] + "," + args[1] + ")");
    }
}