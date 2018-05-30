package Interface;

import Data.DeliveryAddress;
import Data.dealer;
import Data.item;

import java.util.ArrayList;
import java.util.List;

public interface ValidateData {
    boolean check_Dealer_for_null(dealer dealer);

    boolean check_DealerAddress_for_null(DeliveryAddress deliveryAddress);

    boolean check_DealerItem_for_correct(ArrayList<item> item_list);


}
