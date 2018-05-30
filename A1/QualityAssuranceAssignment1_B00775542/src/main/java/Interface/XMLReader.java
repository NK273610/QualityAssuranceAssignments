package Interface;

import Data.order;
import org.wiztools.xsdgen.ParseException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface XMLReader {

    order getDataFromXML(String filepath) throws JAXBException;

    boolean validateXMLSchema(String filepath);

    void xmlToxsd() throws IOException, ParseException;
}
