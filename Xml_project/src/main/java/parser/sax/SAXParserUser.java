package parser.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import model.Flower;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SAXParserUser  {

    private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

    public static List<Flower> parseFlowers(File xml, File xsd){
        List<Flower> flowerList = new ArrayList<>();
        try {
            saxParserFactory.setSchema(SAXValidator.createSchema(xsd));

            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xml, saxHandler);

            flowerList = saxHandler.getFlowerList();
        }catch (SAXException | ParserConfigurationException | IOException ex){
            ex.printStackTrace();
        }

        return flowerList;
    }
}
