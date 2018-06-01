
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

    // In this test we check if xml having valid schema is detected by comapring with xsd
    @Test
    @DisplayName("check for xml having valid schema")
    public void XmlSchemaValidate(){

        assertTrue(xmlreader.validateXMLSchema("order.xml"));

    }

    // In this test we check if xml having invalid schema is detected by comapring with xsd
    @Test
    @DisplayName("check for xml having invalid schema")
    public void XmlSchemaValidateInvalid(){

        assertFalse(xmlreader.validateXMLSchema("BadOrderSchema.xml"));

    }

    // In this this we check if there are no null values in xml if any feild is null it will return true
    @Test
    @DisplayName("check for null values in xml")
    public void CheckNullValuesXml() throws JAXBException {

        assertTrue(xmlreader.check_null_values("orderNull.xml"));

    }

    // In this this we compare the data we get from paring xml to object having expected value
    @Test
    @DisplayName("check data we get from parsing xml")
    public void getDataFromXml() throws JAXBException {

        order objcActual = xmlreader.getDataFromXML("order.xml");
        assertTrue(objExpected.equals(objcActual));

    }

}
