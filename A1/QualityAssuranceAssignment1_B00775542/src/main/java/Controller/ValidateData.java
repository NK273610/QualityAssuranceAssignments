package Controller;

import Data.DeliveryAddress;
import Data.dealer;
import Data.item;
import DataBase.DBclass;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData implements Interface.ValidateData {



    //check null for dealer with regex
    @Override
    public boolean check_Dealer_for_null(dealer dealer) {



        if (dealer.getDealerid() == null || dealer.getDealeraccesskey() == null) {
            return true;
        }
        else if(dealer.getDealeraccesskey().equalsIgnoreCase("") || dealer.getDealeraccesskey().equalsIgnoreCase("") )
        {
            return true;
        }
        else {
            Pattern p = Pattern.compile("^[X]{3}-[0-9]{4}-[A-Z]{4}-[0-9]{4}$");
            Matcher m = p.matcher(dealer.getDealerid());
            if (m.find())
            {
                return false;
            }

            return true;

        }

    }

    //check null for dealer address
    @Override
    public boolean check_DealerAddress_for_null(DeliveryAddress deliveryAddress) {
        if (deliveryAddress.city == null ||
                deliveryAddress.name == null || deliveryAddress.postalCode == null || deliveryAddress.province == null ||
                deliveryAddress.street == null) {
            return true;
        }
        else if (deliveryAddress.city.equalsIgnoreCase("") ||
                deliveryAddress.name.equalsIgnoreCase("") || deliveryAddress.postalCode.equalsIgnoreCase("") || deliveryAddress.province.equalsIgnoreCase("") ||
                deliveryAddress.street.equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    //check null for dealer item
    @Override
    public boolean check_DealerItem_for_correct(ArrayList<item> item_list) {

        for (item item : item_list) {
            if (item.getPartnumber() <= 0 || item.getQuantity() <= 0) {
                return true;
            }

        }
        return false;
    }



}
