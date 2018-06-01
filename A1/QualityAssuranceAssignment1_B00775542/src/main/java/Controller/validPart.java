package Controller;

import DataBase.DBclass;
import Interface.part;

import java.util.HashMap;

public class validPart implements part {

    DBclass db;

    //valid part to check if part no is valid and quantity less than quantity in database
    public validPart(DBclass db) {
        this.db = db;
    }
    @Override
    public boolean check_valid_part(int part_no,int quantity) {

        HashMap<Integer, Integer> mockitem = db.getPartData();

        if (mockitem.containsKey(part_no)) {
            if (mockitem.get(part_no) > 0 && quantity<=mockitem.get(part_no)) {
                return true;
            }

        }
        return false;

    }
}
