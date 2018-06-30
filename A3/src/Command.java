public abstract class Command
{
    protected Object receiver;
    protected String[] args;

    public Command(Object paramObject, String[] paramArrayOfString)
    {
        receiver = paramObject;
        args = paramArrayOfString;
    }

    public Command(Object paramObject)
    {
        receiver = paramObject;
    }

    public abstract void Execute();
}