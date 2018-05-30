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

    @Mock
    DBclass db;

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

    @Test
    @DisplayName("check if dealer is not null")
    public void dealerNotNull(){

        assertFalse(vd.check_Dealer_for_null(objExpected.getDealer()));

    }

    @Test
    @DisplayName("check if dealer address is not null")
    public void dealerAddressNotNull(){

        assertFalse(vd.check_DealerAddress_for_null(objExpected.getDeliveryAddress()));

    }

    @Test
    @DisplayName("check if dealer item is not null")
    public void dealerItemNonZero(){

        assertFalse(vd.check_DealerItem_for_correct(objExpected.getOrderitem()));

    }

    @Test
    @DisplayName("Part no validity")
    public void IsPartNoValid() throws JAXBException {


        assertTrue(vp.check_valid_part(1234));

    }


}
