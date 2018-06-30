public abstract class BoardComponent
{
    protected BoardComponent parent;

    public BoardComponent() { parent = null; }

    public abstract void Operation();

    public abstract void Add(BoardComponent paramBoardComponent);

    public abstract void Remove(BoardComponent paramBoardComponent);

    public void SetParent(BoardComponent paramBoardComponent) { parent = paramBoardComponent; }
}