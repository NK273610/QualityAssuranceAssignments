import java.util.ArrayList;

public class Building
        extends BoardComponent implements IObserver
{
    private int buildingHealth;

    public Building()
    {
        buildingHealth = 2;
    }





    public void Operation() {}




    public void Add(BoardComponent paramBoardComponent) {}




    public void Remove(BoardComponent paramBoardComponent) {}




    public void Update(event paramEvent, BoardComponent paramBoardComponent)
    {
        if (parent != paramBoardComponent)
            return;
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
            buildingHealth -= 1;

            if (buildingHealth == 0)
            {
                GameBoard.Instance().GetBoard().remove(parent);
                GameBoard.Instance().DecrementBuildingCount();
                GameBoard.Instance().GetSub().dettach(this);
            }
        }
    }
}