public class OpenCommand implements ICommand {
    @Override
    public String pasteCommand() {
        return "open -f <path> [-create=0/1]";
    }
}
