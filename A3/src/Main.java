
public class Main
{
    public Main() {}

    public static void main(String[] paramArrayOfString) {
        GameBoard.Instance().ProcessCommands(paramArrayOfString[0]);
    }
}