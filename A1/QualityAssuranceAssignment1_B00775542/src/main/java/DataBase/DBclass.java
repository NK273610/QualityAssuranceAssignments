package DataBase;

import java.util.HashMap;

public class DBclass {

    HashMap<String,String> data;
    HashMap<Integer, Integer> data2;

    public DBclass() {
    }


    public HashMap<String,String> getDealerData()
    {
        data=new HashMap<>();
        return data;
    }

    public HashMap<Integer, Integer> getPartData()
    {
        data=new HashMap<>();

        return data2;
    }


}
