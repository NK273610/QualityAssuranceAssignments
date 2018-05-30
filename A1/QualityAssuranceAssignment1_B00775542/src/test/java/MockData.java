import java.util.HashMap;

public class MockData {

    public  HashMap<String,String> getMockDealer()
    {
        HashMap<String,String> mockdealer=new HashMap<>();

        mockdealer.put("XXX-1234-ABCD-1234","kkklas8882kk23nllfjj88290");
        mockdealer.put("XXX-1235-DEFG-1235","kkklas8882kk23nllfjj88291");
        mockdealer.put("XXX-1237-ACDC-1237","kkklas8882kk23nllfjj88292");
        mockdealer.put("XXX-1238-BAND-1238","kkklas8882kk23nllfjj88293");
        mockdealer.put("XXX-1239-LTTF-1239","kkklas8882kk23nllfjj88294");
        mockdealer.put("XXX-1230-KBDC-1230","kkklas8882kk23nllfjj88295");

        return mockdealer;
    }

    public   HashMap<Integer,Integer> getMockItem()
    {
        HashMap<Integer,Integer> mockitem=new HashMap<>();

        mockitem.put(1234,23);
        mockitem.put(2254,20);
        mockitem.put(1200,8);
        mockitem.put(1987,4);
        mockitem.put(1377,23);
        mockitem.put(1900,2);

        return mockitem;
    }
}
