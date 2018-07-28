public class PrintCommand implements ICommand {
    @Override
    public String pasteCommand() {
        return "print -f <path> [-colour=0/1] [-two-sided=0/1]";

    }
}
