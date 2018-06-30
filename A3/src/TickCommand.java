import java.io.PrintStream;





public class TickCommand
        extends Command
{
    public TickCommand(Object paramObject, String[] paramArrayOfString)
    {
        super(paramObject, paramArrayOfString);
    }



    public void Execute()
    {
        GameBoard localGameBoard = (GameBoard)receiver;



        int i = Integer.parseInt(args[0]);
        System.out.println("Ticking " + i + " times.");
        for (int j = 0; j < i; j++)
        {
            localGameBoard.DoTick();
        }
    }
}