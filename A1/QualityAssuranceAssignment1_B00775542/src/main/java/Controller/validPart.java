package Controller;

import DataBase.DBclass;
import Interface.part;

import java.util.HashMap;

public class validPart implements part {

    DBclass db;

    public validPart(DBclass db) {
        this.db = db;
    }
    @Override
    public boolean check_valid_part(int part_no) {

        HashMap<Integer, Integer> mockitem = db.getPartData();

        if (mockitem.containsKey(part_no)) {
            if (mockitem.get(part_no) > 0) {
                return true;
            }

        }
        return false;

    }
}
