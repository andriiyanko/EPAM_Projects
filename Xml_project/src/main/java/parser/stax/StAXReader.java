package parser.stax;

import model.Flower;
import model.GrowingTip;
import model.VisualParameter;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {

    public static List<Flower> parseFlowers(File xml, File xsd){
        List<Flower> flowerList = new ArrayList<>();
        Flower flower = null;
        VisualParameter visualParameter = null;
        GrowingTip growingTip = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
            while (xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name){
                        case "flower":
                            flower = new Flower();
                            Attribute idAttr = startElement.getAttributeByName(new QName("flowerNo"));
                            if (idAttr != null){
                                flower.setFlowerNo(Integer.parseInt(idAttr.getValue()));
                            }
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert flower != null;
                            flower.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "soil":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert flower != null;
                            flower.setSoil(xmlEvent.asCharacters().getData());
                            break;
                        case "origin":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert flower != null;
                            flower.setOrigin(xmlEvent.asCharacters().getData());
                        case "visual_parameters":
                            xmlEvent = xmlEventReader.nextEvent();
                            visualParameter = new VisualParameter();
                            break;
                        case "color_stem":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert visualParameter != null;
                            visualParameter.setColor_stem(xmlEvent.asCharacters().getData());
                            break;
                        case "color_leaf":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert visualParameter != null;
                            visualParameter.setColor_leaf(xmlEvent.asCharacters().getData());
                            break;
                        case "flower_average_size":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert visualParameter != null;
                            visualParameter.setFlower_average_size(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "growing_tips":
                            xmlEvent = xmlEventReader.nextEvent();
                            growingTip = new GrowingTip();
                            break;
                        case "temperature":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert growingTip != null;
                            growingTip.setTemperature(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "lighting":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert growingTip != null;
                            growingTip.setLighting(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        case "watering":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert growingTip != null;
                            growingTip.setWatering(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "multiplying":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert flower != null;
                            flower.setVisual_parameter(visualParameter);
                            flower.setGrowing_tip(growingTip);
                            flower.setMultiplying(xmlEvent.asCharacters().getData());
                            break;
                    }
                }
                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("flower")){
                        flowerList.add(flower);
                    }
                }
            }

        }catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return flowerList;
    }
}
