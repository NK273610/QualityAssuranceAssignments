package Question2.javaClass;

import Question2.Interface.BookDvdCommonInterface;
import Question2.Interface.DvdInterface;

import java.time.Duration;
import java.util.ArrayList;

public class DVD implements DvdInterface, BookDvdCommonInterface {
    @Override
    public ArrayList<String> GetCastList() {
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Alden Ehrenreich");
        cast.add("Joonas Suotamo");
        cast.add("Woody Harrelson");
        cast.add("Emilia Clarke");
        cast.add("Donald Glover");
        cast.add("Thandie Newton");
        cast.add("Paul Bettany");
        return cast;
    }

    @Override
    public Duration GetPlayTime() {
        return Duration.ofMinutes(135);
    }

    @Override
    public String GetTitle() {
        return "Solo: A Star Wars Story";
    }

    @Override
    public boolean IsDigitalOnly() {
        return false;
    }
}
