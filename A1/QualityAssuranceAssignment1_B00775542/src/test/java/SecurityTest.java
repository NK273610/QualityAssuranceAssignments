import Controller.secure;
import DataBase.DBclass;
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
public class SecurityTest {

    //we mock the database class so when called by test class it gets data from mock class in test package
    @Mock
    DBclass db;

    //object of MockData in test package
    MockData md;

    //object of secure class
    secure sc;

    @Before
    public void create() {

        md = new MockData();
        Mockito.when(db.getDealerData()).thenReturn(md.getMockDealer());
        sc = new secure(db);


    }

    //In this we check if delarer id and access key are present in mock data
    @Test
    @DisplayName("DealerAuthorizedTest")
    public void IsDealerAuthorized() throws JAXBException {


        assertTrue(sc.IsDealerAuthorized("XXX-1234-ABCD-1234", "kkklas8882kk23nllfjj88290"));

    }
    @Test
    @DisplayName("DealerAuthorizedTest for dealerid for regular expression")
    public void IsDealerAuthorizedRegex() throws JAXBException {


        assertFalse(sc.IsDealerAuthorized("XXX-1234-ABD-1234", "kkklas8882kk23nllfjj88290"));

    }

    @Test
    @DisplayName("DealerAuthorizedTest for invalid DealerId")
    public void IsDealerAuthorizedDealerIdNotValid() throws JAXBException {


        assertFalse(sc.IsDealerAuthorized("XXX-1234-KPTM-1234", "kkklas8882kk23nllfjj88290"));

    }
    @Test
    @DisplayName("DealerAuthorizedTest for Access Key invalid")
    public void IsDealerAuthorizedAccessKeyNotValid() throws JAXBException {


        assertFalse(sc.IsDealerAuthorized("XXX-1235-DEFG-1235", "8882kk23nllfjj88290"));

    }
}
