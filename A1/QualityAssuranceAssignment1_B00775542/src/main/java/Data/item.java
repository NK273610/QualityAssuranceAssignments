package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class item {

    @XmlElement(name="partnumber")
    int partnumber;

    @XmlElement(name="quantity")
    int quantity;

    public int getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(int partnumber) {
        this.partnumber = partnumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
