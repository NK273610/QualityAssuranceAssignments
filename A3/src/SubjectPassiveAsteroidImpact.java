import java.util.ArrayList;
import java.util.List;

public class SubjectPassiveAsteroidImpact implements ISubjectAsteroidImapacts
{
    private List<IObserver> bc = new ArrayList();

    public SubjectPassiveAsteroidImpact() {}

    public void attach(IObserver paramIObserver) { bc.add(paramIObserver); }

    public void dettach(IObserver paramIObserver) {
        bc.remove(paramIObserver);
    }

    public void notifyAllObservers(event paramEvent, BoardComponent paramBoardComponent) {
        ArrayList<IObserver> localArrayList = new ArrayList(bc);
        for (IObserver localIObserver : localArrayList) {
            localIObserver.Update(paramEvent, paramBoardComponent);
        }
    }

    public List getList() {
        return bc;
    }
}