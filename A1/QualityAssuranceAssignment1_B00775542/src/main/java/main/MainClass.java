package main;

import Controller.*;
import Data.order;
import DataBase.DBclass;
import Interface.PARTMANAGER;
import Interface.Security;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException {

        XMLReader xr=new XMLReader();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("order");
        doc.appendChild(rootElement);
        DBclass db;
        Security sec;
        partmanager pm;
        int temp=0;
        order or=null;
        System.out.println("Enter the name of the file that you have kept in resource folder under src/main");
        Scanner scn=new Scanner(System.in);
        String filename=scn.next();
       if (xr.validateXMLSchema(filename)==true)
       {
           if(xr.check_null_values(filename)==false)
           {
               or=new order();
               or=xr.getDataFromXML(filename);
           }
           else
           {
               System.out.println("The xml has null values or values that are not valid");
           }
       }
       else
       {
           //reference:- https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
           //I have not copied the code just taken reference to create xml
           Element result = doc.createElement("result");
           result.appendChild(doc.createTextNode("failure"));
           Element error = doc.createElement("error");
           error.appendChild(doc.createTextNode("Invalid order"));
           rootElement.appendChild(result);
           rootElement.appendChild(error);
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);
           StreamResult fileres = new StreamResult(new File("response.xml"));
           transformer.transform(source, fileres);
           return;

       }

       if(or!=null)
       {

           db=new DBclass();
           pm=new partmanager();
           sec=new secure(db);
           Element rootElement2 = doc.createElement("orderitems");
           rootElement.appendChild(rootElement2);

           if (sec.IsDealerAuthorized(or.getDealer().getDealerid(),or.getDealer().getDealeraccesskey())==true)
           {
               for (int i=0;i<or.getOrderitem().size();i++)
               {
                   Element item = doc.createElement("item");
                   rootElement2.appendChild(item);
                   Element partno = doc.createElement("partnumber");
                   Element quantity = doc.createElement("quantity");
                   Element result = doc.createElement("result");
                   Element error = doc.createElement("errormessage");
                   PARTMANAGER.PartResponse res=pm.SubmitPartForManufactureAndDelivery(or.getOrderitem().get(i).getPartnumber(),
                           or.getOrderitem().get(i).getQuantity(),or.getDeliveryAddress());
                   partno.appendChild(doc.createTextNode(String.valueOf(or.getOrderitem().get(i).getPartnumber())));
                   quantity.appendChild(doc.createTextNode(String.valueOf(or.getOrderitem().get(i).getQuantity())));
                   if(res== PARTMANAGER.PartResponse.SUCCESS)
                   {
                       result.appendChild(doc.createTextNode(String.valueOf(PARTMANAGER.PartResponse.SUCCESS)));
                       error.appendChild(doc.createTextNode(""));


                   }
                   else if(res==PARTMANAGER.PartResponse.OUT_OF_STOCK)
                   {
                       result.appendChild(doc.createTextNode("Failure"));
                       error.appendChild(doc.createTextNode(String.valueOf(PARTMANAGER.PartResponse.OUT_OF_STOCK)));

                   }
                   else
                   {
                       result.appendChild(doc.createTextNode("Failure"));
                       error.appendChild(doc.createTextNode(String.valueOf(PARTMANAGER.PartResponse.NO_LONGER_MANUFACTURED+" or invalid part")));
                   }
                   item.appendChild(partno);
                   item.appendChild(quantity);
                   item.appendChild(result);
                   item.appendChild(error);
               }

               TransformerFactory transformerFactory = TransformerFactory.newInstance();
               Transformer transformer = transformerFactory.newTransformer();
               DOMSource source = new DOMSource(doc);
               StreamResult fileres = new StreamResult(new File("response.xml"));
               transformer.transform(source, fileres);
               return;
           }

           else
           {
               //reference:- https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
               //I have not copied the code just taken reference to create xml
               Element result = doc.createElement("result");
               result.appendChild(doc.createTextNode("failure"));
               Element error = doc.createElement("error");
               error.appendChild(doc.createTextNode("Dealer Not Authorized"));
               rootElement.appendChild(result);
               rootElement.appendChild(error);
               TransformerFactory transformerFactory = TransformerFactory.newInstance();
               Transformer transformer = transformerFactory.newTransformer();
               DOMSource source = new DOMSource(doc);
               StreamResult fileres = new StreamResult(new File("response.xml"));
               transformer.transform(source, fileres);
               return;
           }
       }



    }
}
