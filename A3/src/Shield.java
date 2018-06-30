import java.util.ArrayList;

public class Shield extends BoardComponent implements IObserver
{
    private int shieldHealth;
    BoardComponent shielded;
    private int x;
    private int y;

    public Shield(BoardComponent paramBoardComponent, int paramInt1, int paramInt2)
    {
        shielded = paramBoardComponent;
        shieldHealth = 2;
        x = paramInt1;
        y = paramInt2;
    }

    public void Operation()
    {
        shielded.Operation();
    }

    public void Add(BoardComponent paramBoardComponent)
    {
        shielded.Add(paramBoardComponent);
    }


    public void Remove(BoardComponent paramBoardComponent)
    {
        shielded.Remove(paramBoardComponent);
    }

    private boolean shieldForMe(BoardComponent paramBoardComponent)
    {
        return (shielded == paramBoardComponent) || (this == paramBoardComponent);
    }

    public void Update(event paramEvent, BoardComponent paramBoardComponent)
    {
        if (((paramEvent == event.SHIELD_ADDED) || (paramEvent == event.SHIELD_REMOVED)) &&
                (!shieldForMe(paramBoardComponent)))
            return;
        if ((paramEvent == event.ASTEROID_ATTACK) &&
                (!asteroidForMe(paramBoardComponent))) {
            return;
        }
        if (paramEvent == event.SHIELD_ADDED)
        {
            GameBoard.Instance().GetSub().dettach(this);
            GameBoard.Instance().GetShieldedSub().attach(this);
        }

        if (paramEvent == event.SHIELD_REMOVED)
        {
            GameBoard.Instance().GetShieldedSub().dettach(this);
            GameBoard.Instance().GetSub().attach(this);
        }

        if (paramEvent == event.ASTEROID_ATTACK)
        {
            shieldHealth -= 1;
            if (shieldHealth == 0)
            {
                ArrayList localArrayList = GameBoard.Instance().GetBoard();
                ((ArrayList)localArrayList.get(x)).set(y, shielded);
                GameBoard.Instance().GetSub().dettach(this);
                GameBoard.Instance().GetShieldedSub().notifyAllObservers(event.SHIELD_REMOVED, shielded);
            }
        }
    }



    private boolean asteroidForMe(BoardComponent paramBoardComponent)
    {
        if ((shielded instanceof Square))
            return shielded == paramBoardComponent;
        return ((Shield)shielded).asteroidForMe(paramBoardComponent);
    }
}