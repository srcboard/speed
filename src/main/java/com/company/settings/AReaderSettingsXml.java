package com.company.settings;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public abstract class AReaderSettingsXml implements IReaderSettings {

    private Document document;

    public AReaderSettingsXml() {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            this.document = builder.parse(IReaderSettings.findConfigurationFile("properties.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getProperty(String property) {

        NodeList nodeLst = document.getElementsByTagName(property);

        if (nodeLst.getLength() != 0) {
            return nodeLst.item(0).getFirstChild().getNodeValue();
        }

        return null;

    }

    @Override
    public String getProperty(String property, PropertyType type) {

        if (type == PropertyType.FullPath) {

            String absolutePath = new File(".").getAbsolutePath();
            return absolutePath + "\\src\\main\\resources\\" + getProperty(property);

        } else if (type == PropertyType.Number) {

            return getProperty(property);

        }

        return getProperty(property);

    }
}
