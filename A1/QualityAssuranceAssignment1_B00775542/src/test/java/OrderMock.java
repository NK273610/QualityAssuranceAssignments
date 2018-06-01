import Data.DeliveryAddress;
import Data.dealer;
import Data.item;
import Data.order;

import java.util.ArrayList;
import java.util.List;

public class OrderMock {


    //order object mock
    public static order getOrderMock()
    {
        order ordr=new order();


        ordr.setDealer(getDealerdata());

        ordr.setOrderitem((ArrayList<item>) getOrderItem());
        ordr.setDeliveryAddress(getDeliveryAddress());
        return ordr;
    }
    public static DeliveryAddress getDeliveryAddress()
    {
        DeliveryAddress da=new DeliveryAddress();
        da.setCity("Halifax");
        da.setName("Mrs. Jane Smith");
        da.setPostalCode("B2T1A4");
        da.setStreet("35 Streetname");
        da.setProvince("NS");
        return da;
    }
    public static dealer getDealerdata()
    {
        dealer deal=new dealer();
        deal.setDealeraccesskey("kkklas8882kk23nllfjj88290");
        deal.setDealerid("XXX-1234-ABCD-1234");
        return deal;
    }

    public static List<item> getOrderItem()
    {
        item it=new item();
        item it2=new item();


        it.setPartnumber(1234);
        it.setQuantity(2);
        it2.setPartnumber(5678);
        it2.setQuantity(25);
        ArrayList<item> lis=new ArrayList<item>();
        lis.add(it);
        lis.add(it2);
        return lis;
    }

}
