
import Controller.XMLReader;
import Data.order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.*;


public class TestXMLClass {

    XMLReader xmlreader;
    order objExpected;

    @Before
    public void setUp() {
        xmlreader = new XMLReader();
        objExpected=OrderMock.getOrderMock();
    }

    @After
    public void tearDown() {
        xmlreader=null;
        objExpected=null;
    }

    @Test
    @DisplayName("check if xml has valid schema")
    public void XmlSchemaValidate(){

        assertTrue(xmlreader.validateXMLSchema("order.xml"));

    }

    @Test
    @DisplayName("check if xml has in valid schema")
    public void XmlSchemaValidateInvalid(){

        assertFalse(xmlreader.validateXMLSchema("BadOrderSchema.xml"));

    }
    @Test
    @DisplayName("check null values in xml")
    public void CheckNullValuesXml() throws JAXBException {

        assertTrue(xmlreader.check_null_values("orderNull.xml"));

    }
    @Test
    @DisplayName("check data we get from the xml")
    public void getDataFromXml() throws JAXBException {

        order objcActual = xmlreader.getDataFromXML("order.xml");
        assertTrue(objExpected.equals(objcActual));

    }

}
