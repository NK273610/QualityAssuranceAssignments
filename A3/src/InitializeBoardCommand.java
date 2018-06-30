public class InitializeBoardCommand extends Command
{
    public InitializeBoardCommand(Object paramObject, String[] paramArrayOfString)
    {
        super(paramObject, paramArrayOfString);
    }



    public void Execute()
    {
        GameBoard localGameBoard = (GameBoard)receiver;

        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        localGameBoard.SetBoard(localGameBoard.GetFactory().MakeBoard(j, i));
    }
}