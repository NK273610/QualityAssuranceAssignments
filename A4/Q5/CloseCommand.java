public class CloseCommand implements  ICommand {
    @Override
    public String pasteCommand() {
        return "close -f <path>";
    }
}
