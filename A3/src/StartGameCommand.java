public class StartGameCommand extends Command
{
    public StartGameCommand(Object paramObject, String[] paramArrayOfString)
    {
        super(paramObject, paramArrayOfString);
    }



    public void Execute()
    {
        GameBoard localGameBoard = (GameBoard)receiver;
        localGameBoard.StartGame();
    }
}