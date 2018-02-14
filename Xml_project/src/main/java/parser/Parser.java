package parser;

import comparator.FlowerComparator;
import filechecker.ExtensionChecker;
import model.Flower;
import parser.dom.DOMParserUser;
import parser.sax.SAXParserUser;
import parser.stax.StAXReader;

import javax.xml.crypto.dsig.TransformException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class Parser {

    public static void main(String[] args) {

            try {

                File xml = new File("src\\main\\resources\\xml\\flowers.xml");
                File xsd = new File("src\\main\\resources\\xml\\flower.xsd");

                File xsl = new File("src\\main\\resources\\xml\\flower.xsl");


                if (checkIfXML(xml) && checkIfXSD(xsd)) {

                    // DOM
                    printList(DOMParserUser.getFlowerList(xml,xsd), "DOM");

                    // StAX
                    printList(StAXReader.parseFlowers(xml,xsd), "StAX");

                    //SAX
                    printList(SAXParserUser.parseFlowers(xml,xsd),"SAX");

                }

                StreamSource xslSource = new StreamSource(xsl);
                StreamSource xmlSource = new StreamSource(xml);
                Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
                transformer.transform(xmlSource, new StreamResult(new File("F:\\_EPAM\\flower.html")));

                StreamResult consoleOut = new StreamResult(System.out);
                // Transform the document and print the content to console
                transformer.transform(xmlSource, consoleOut);

            }catch (TransformerException e){
                e.printStackTrace();
            }


    }


    private static boolean checkIfXSD(File xsd) {
        return ExtensionChecker.isXSD(xsd);
    }

    private static boolean checkIfXML(File xml) {
        return ExtensionChecker.isXML(xml);
    }

    private static void printList(List<Flower> flowers, String parserName){
        Collections.sort(flowers, new FlowerComparator());
        System.out.println(parserName);

        for (Flower flower:flowers) {
            System.out.println(flower);
        }
    }

}
