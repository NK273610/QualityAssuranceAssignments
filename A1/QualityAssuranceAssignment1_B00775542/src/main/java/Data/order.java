package Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class order {


    @XmlElement(name="dealer")
    private dealer dealer;

    @XmlElementWrapper(name="orderitems")
    @XmlElement(name="item")
    private ArrayList<item> orderitem;




    @XmlElement(name="deliveryaddress")
    private DeliveryAddress deliveryAddress;

    public Data.dealer getDealer() {
        return dealer;
    }

    public void setDealer(Data.dealer dealer) {
        this.dealer = dealer;
    }

    public ArrayList<item> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(ArrayList<item> orderitem) {
        this.orderitem = orderitem;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        order order = (order) o;
        if(this.dealer.getDealeraccesskey().equalsIgnoreCase(order.dealer.getDealeraccesskey())
                && this.dealer.getDealerid().equalsIgnoreCase(order.dealer.getDealerid()))
        {
            if (this.getOrderitem().size()==this.getOrderitem().size())
            {
                for(int i=0;i<this.getOrderitem().size();i++)
                {
                    if(this.getOrderitem().get(i).partnumber!=order.getOrderitem().get(i).partnumber
                            || this.getOrderitem().get(i).quantity!=order.getOrderitem().get(i).quantity)
                    {
                        return false;
                    }
                }
                if(this.getDeliveryAddress().street.equalsIgnoreCase(order.deliveryAddress.street)&&
                        this.getDeliveryAddress().city.equalsIgnoreCase(order.deliveryAddress.city)
                        && this.getDeliveryAddress().province.equalsIgnoreCase(order.deliveryAddress.province)
                        && this.getDeliveryAddress().postalCode.equalsIgnoreCase(order.deliveryAddress.postalCode)
                        && this.getDeliveryAddress().name.equalsIgnoreCase(order.deliveryAddress.name))
                {
                    return true;
                }
            }
        }
        return false;
    }

}
