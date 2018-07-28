import java.util.HashMap;
public class Help {

    HashMap<String,ICommand> commandMap=new HashMap<>();

    public String GetHelp(String command)
    {
        if (command != null && command.length() != 0)
        {
            return Help().get(command).pasteCommand();
        }
        return ListAllCommands();
    }

    public HashMap<String,ICommand> Help()
    {
        commandMap.put("print",new PrintCommand());
        commandMap.put("open",new OpenCommand());
        commandMap.put("close",new CloseCommand());
        return commandMap;
    }

    public String ListAllCommands()
    {
        return "Commands: print, open, close";
    }
}
