import java.util.ArrayList;


public class Square
        extends BoardComponent
{
    final ArrayList<BoardComponent> children;
    private BoardComponent parent;

    public Square()
    {
        children = new ArrayList();
    }


    public void Operation()
    {
        int i = 1;
        ArrayList localArrayList = new ArrayList(children);
        for (int j = 0; j < localArrayList.size(); j++)
        {
            BoardComponent localBoardComponent = (BoardComponent)localArrayList.get(j);
            localBoardComponent.Operation();
        }
    }



    public void Add(BoardComponent paramBoardComponent)
    {
        children.add(paramBoardComponent);
        paramBoardComponent.SetParent(this);
    }


    public void Remove(BoardComponent paramBoardComponent)
    {
        children.remove(paramBoardComponent);
    }
}