import java.util.ArrayList;
import java.util.List;

public class Question1
{

    public String BuildBookQuoteHTML()
    {
        StringBuilder builder = new StringBuilder();
        addHeader(builder);
        List<String> quotes=addQuotes();
        addParagraph(quotes,builder);
        addFooter(builder);
        return builder.toString();
    }

    public StringBuilder addHeader(StringBuilder builder)
    {
        builder.append("<H1>A page of famous book quotes!</H1>\n");
        builder.append("<H2>- Some book reviewer</H2>");
        return builder;
    }

    public StringBuilder addFooter(StringBuilder builder)
    {
        builder.append("<A HREF=\"page2.html\">Click here to go to the next page!</A>\n");
        return builder;
    }

    public List<String> addQuotes()
    {
        List<String> quotes=new ArrayList<String>();
        quotes.add("I know. I was there. I saw the great void in your soul, and you saw mine.");
        quotes.add("She says nothing at all, but simply stares upward into the dark sky and watches, with sad eyes, the slow dance of the infinite stars.");
        quotes.add("Clocks slay time… time is dead as long as it is being clicked off by little wheels; only when the clock stops does time come to life.");
        quotes.add("None of those other things makes a difference. Love is the strongest thing in the world, you know. Nothing can touch it. Nothing comes close. If we love each other we’re safe from it all. Love is the biggest thing there is.");
        quotes.add("Sometimes we get sad about things and we don’t like to tell other people that we are sad about them. We like to keep it a secret. Or sometimes, we are sad but we really don’t know why we are sad, so we say we aren’t sad but we really are.");
        quotes.add("I know not all that may be coming, but be it what it will, I’ll go to it laughing.");
        quotes.add("Maybe ever’body in the whole damn world is scared of each other.");
        quotes.add("Life is to be lived, not controlled; and humanity is won by continuing to play in face of certain defeat.");
        quotes.add("It's the possibility of having a dream come true that makes life interesting.");
        quotes.add("I cannot fix on the hour, or the spot, or the look or the words, which laid the foundation. It is too long ago. I was in the middle before I knew that I had begun.");
        quotes.add("There is no greater agony than bearing an untold story inside you.");
        quotes.add("Still, there are times I am bewildered by each mile I have traveled, each meal I have eaten, each person I have known, each room in which I have slept. As ordinary as it all appears, there are times when it is beyond my imagination.");
        quotes.add("And so we beat on, boats against the current, borne back ceaselessly into the past.");
        quotes.add("Hello, babies. Welcome to Earth. It's hot in the summer and cold in the winter. It's round and wet and crowded. At the outside, babies, you've got about a hundred years here. There's only one rule that I know of, babies—God damn it, you've got to be kind.");
        quotes.add("He stepped down, trying not to look long at her, as if she were the sun, yet he saw her, like the sun, even without looking.");
        quotes.add("How wonderful it is that nobody need wait a single moment before starting to improve the world.");
        return quotes;
    }

    public StringBuilder addParagraph(List<String> builder,StringBuilder builder_para)
    {
        try
        {
            for (int i = 0; i < builder.size(); i++)
            {
                builder_para.append("<P>");
                builder_para.append(builder.get(i));
                builder_para.append("</P>\n");
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Null Pointer Exception");
        }

        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Index Out Of Bound Exception");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            builder=null;
        }
        return builder_para;
    }


}
