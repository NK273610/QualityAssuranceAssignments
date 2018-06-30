public class GameState implements IState
{
    public GameState() {}

    public boolean IsGameOver()
    {
        return GameBoard.Instance().GetBuildingCount() == 0;
    }
}