package com.eis.insurance.andreiPiniuta.db;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IDGenerator {

    private static final IDGenerator generator = new IDGenerator();

    public static  IDGenerator getGenerator () {
        return generator;
    }

    private IDGenerator() {

    }

    public Integer getNewID() throws ParserConfigurationException, IOException, SAXException {
        Path destination = Paths.get("D:/policy/PolicyXml.xml");
        if (Files.exists(destination)) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("D:/policy/PolicyXml.xml");
            Element rootTag = document.getDocumentElement();
            NodeList IDList = rootTag.getElementsByTagName("ID");
            Integer size = IDList.getLength();
            Integer ID = 0;
            for(int i=0; i < size; i++) {
                Element IDElement = (Element) IDList.item(i);
                String IDStr =  IDElement.getTextContent();
                Integer newID = Integer.parseInt(IDStr);
                ID = newID;
            }
            ID++;
            return ID;
        } else {
            return 1;
        }
    }
}
