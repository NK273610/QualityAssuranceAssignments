package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class dealer {

    @XmlElement(name="dealerid")
    private String dealerid;

    @XmlElement(name="dealeraccesskey")
    private String dealeraccesskey;

    public String getDealerid() {
        return dealerid;
    }

    public void setDealerid(String dealerid) {
        this.dealerid = dealerid;
    }

    public String getDealeraccesskey() {
        return dealeraccesskey;
    }

    public void setDealeraccesskey(String dealeraccesskey) {
        this.dealeraccesskey = dealeraccesskey;
    }
}
