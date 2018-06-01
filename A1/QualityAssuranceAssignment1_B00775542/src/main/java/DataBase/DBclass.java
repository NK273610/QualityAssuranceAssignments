package DataBase;

import java.util.HashMap;

public class DBclass implements Interface.DBclass {

    HashMap<String,String> data;
    HashMap<Integer, Integer> data2;

    public DBclass() {
    }


    @Override
    public HashMap<String,String> getDealerData()
    {
        data=new HashMap<>();
        data.put("XXX-1234-ABCD-1234","kkklas8882kk23nllfjj88290");
        data.put("XXX-1235-DEFG-1235","kkklas8882kk23nllfjj88291");
        data.put("XXX-1237-ACDC-1237","kkklas8882kk23nllfjj88292");
        data.put("XXX-1238-BAND-1238","kkklas8882kk23nllfjj88293");
        data.put("XXX-1239-LTTF-1239","kkklas8882kk23nllfjj88294");
        data.put("XXX-1230-KBDC-1230","kkklas8882kk23nllfjj88295");
        return data;
    }

    @Override
    public HashMap<Integer, Integer> getPartData()
    {
        data2=new HashMap<>();
        data2.put(1234,123);
        data2.put(5678,100);
        data2.put(2254,20);
        data2.put(1200,8);
        data2.put(1987,4);
        data2.put(1377,23);
        data2.put(1900,2);

        return data2;
    }


}
