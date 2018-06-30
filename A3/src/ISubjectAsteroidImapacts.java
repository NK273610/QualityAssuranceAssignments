import java.util.List;

public abstract interface ISubjectAsteroidImapacts
{
    public abstract void attach(IObserver paramIObserver);

    public abstract void dettach(IObserver paramIObserver);

    public abstract void notifyAllObservers(event paramEvent, BoardComponent paramBoardComponent);

    public abstract List getList();
}
