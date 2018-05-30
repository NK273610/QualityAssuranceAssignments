package Controller;




import Data.item;
import Data.order;
import org.wiztools.xsdgen.ParseException;
import org.wiztools.xsdgen.XsdGen;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class XMLReader implements Interface.XMLReader {

    @Override
    public order getDataFromXML(String filepath) throws JAXBException
    {
        XMLReader xr=new XMLReader();
        order order=new order();
        JAXBContext jc = JAXBContext.newInstance(order.class);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filepath).getFile());
        String absolutePath = file.getAbsolutePath();
        if (xr.validateXMLSchema(filepath)==true)
        {


            Unmarshaller unmarshaller = jc.createUnmarshaller();
             order= (Data.order) unmarshaller.unmarshal(new File(absolutePath));

        }

        return order;
    }

    public boolean check_null_values(String filepath) throws JAXBException
    {
        XMLReader xr=new XMLReader();
        order order=new order();
        JAXBContext jc = JAXBContext.newInstance(order.class);


        if (xr.validateXMLSchema(filepath)==true) {

            ValidateData vd=new ValidateData();
            order=getDataFromXML(filepath);
            if(vd.check_Dealer_for_null(order.getDealer())==false && vd.check_DealerAddress_for_null(order.getDeliveryAddress())==false
                    && vd.check_DealerItem_for_correct(order.getOrderitem())==false)
            {
                return false;
            }

        }

        return true;
    }
    @Override
    public boolean validateXMLSchema(String filepath) {

        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filepath).getFile());
        String absolutePath = file.getAbsolutePath();
        File file2 = new File(classLoader.getResource("order.xsd").getFile());
        String absolutePath_xsd = file2.getAbsolutePath();

        try {

            Schema schema = factory.newSchema(new File(absolutePath_xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(absolutePath)));
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;

        }

        catch (SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;

        }

        return true;
    }

    @Override
    public void xmlToxsd() throws IOException, ParseException {
        XsdGen gen = new XsdGen();
        gen.parse(new File("/Users/nikhildhirmalani/Desktop/QualityAssuranceAssignment1_B00775542/Files/order.xml"));
        File out = new File("/Users/nikhildhirmalani/Desktop/QualityAssuranceAssignment1_B00775542/Files/order.xsd");
        gen.write(new FileOutputStream(out));
    }
}
