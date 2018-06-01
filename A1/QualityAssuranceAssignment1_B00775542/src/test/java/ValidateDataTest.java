import Controller.ValidateData;
import Controller.XMLReader;
import Controller.validPart;
import Data.order;
import DataBase.DBclass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ValidateDataTest {

    //we mock the database class so when called by test class it gets data from mock class in test package
    @Mock
    DBclass db;

    //object of classes created
    order objExpected;
    ValidateData vd;
    MockData md;
    validPart vp;

    @Before
    public void setUp() {

        md=new MockData();

        objExpected=OrderMock.getOrderMock();
        Mockito.when(db.getPartData()).thenReturn(md.getMockItem());
        vd = new ValidateData();
        vp=new validPart(db);
    }

    @After
    public void tearDown() {
        vd=null;
        objExpected=null;
    }

    //test the method check_Dealer_for_null to check the daler is not null
    @Test
    @DisplayName("check if dealer is not null")
    public void dealerNotNull(){

        assertFalse(vd.check_Dealer_for_null(objExpected.getDealer()));

    }

    //test the method check_DealerAddress_for_null to check dealer address is not null
    @Test
    @DisplayName("check if dealer address is not null")
    public void dealerAddressNotNull(){

        assertFalse(vd.check_DealerAddress_for_null(objExpected.getDeliveryAddress()));

    }

    //Test the method check_DealerItem_for_correct to check if partnumber is not null
    @Test
    @DisplayName("check if dealer item is not null")
    public void dealerItemNonZero(){

        assertFalse(vd.check_DealerItem_for_correct(objExpected.getOrderitem()));

    }

    //test the method check_valid_part to check if part no is valid
    @Test
    @DisplayName("Part no validity")
    public void IsPartNoValid() throws JAXBException {


        assertTrue(vp.check_valid_part(1234,2));

    }

    //test the method check_valid_part to check if quantity is valid
    @Test
    @DisplayName("Part quantity validity")
    public void IsPartQuantityNoValid() throws JAXBException {


        assertFalse(vp.check_valid_part(1234,25));

    }


}
