package lab2.controller;

import lab2.model.EntryModel;
import lab2.model.StudentEntity;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLLoadComponent {
    private static EntryModel newModel;
    private String filePath;

    public XMLLoadComponent(String path) {
        newModel = new EntryModel();
        this.filePath = path;
    }

    public EntryModel loadFromFile(){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XMLHandler handler = new XMLHandler();
            parser.parse(filePath, handler);
        }
        catch (SAXException se){
            JOptionPane.showMessageDialog(null, "?");
        }
        catch (ParserConfigurationException pce){
            JOptionPane.showMessageDialog(null, "???");
        }
        catch (IOException ioe){
            JOptionPane.showMessageDialog(null, "??");
        }
        return  newModel;
    }

    private static class XMLHandler extends DefaultHandler {
        private String currentElement;
        private String firstName, secondName, fatherName;
        private String group;
        private String sem1;
        private String sem2;
        private String sem3;
        private String sem4;
        private String sem5;
        private String sem6;
        private String sem7;
        private String sem8;
        private String sem9;
        private String sem10;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length);
            data = data.replace("\n", "").trim();
            if (!data.isEmpty()) {
                if (currentElement.equals("secondName")) {
                    secondName = data;
                }
                if (currentElement.equals("firstName")) {
                    firstName = data;
                }
                if (currentElement.equals("fatherName")) {
                    fatherName = data;
                }
                if (currentElement.equals("studentGroup")) {
                    group = data;
                }
                if (currentElement.equals("sem1")) {
                    sem1 = data;
                }
                if (currentElement.equals("sem2")) {
                    sem2 = data;
                }
                if (currentElement.equals("sem3")) {
                    sem3 = data;
                }
                if (currentElement.equals("sem4")) {
                    sem4 = data;
                }
                if (currentElement.equals("sem5")) {
                    sem5 = data;
                }
                if (currentElement.equals("sem6")) {
                    sem6 = data;
                }
                if (currentElement.equals("sem7")) {
                    sem7 = data;
                }
                if (currentElement.equals("sem8")) {
                    sem8 = data;
                }
                if (currentElement.equals("sem9")) {
                    sem9 = data;
                }
                if (currentElement.equals("sem10")) {
                    sem10 = data;
                }

            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (firstName != null &&
                    fatherName != null &&
                    secondName != null &&
                    group != null &&
                    sem1 != null &&
                    sem2 != null &&
                    sem3 != null &&
                    sem4 != null &&
                    sem5 != null &&
                    sem6 != null &&
                    sem7 != null &&
                    sem8 != null &&
                    sem9 != null &&
                    sem10 != null) {
                ArrayList<String> nameParts = new ArrayList<>();
                nameParts.add(firstName);
                nameParts.add(secondName);
                nameParts.add(fatherName);
                ArrayList<Integer> socialWork = new ArrayList<>();
                socialWork.add(Integer.parseInt(sem1));
                socialWork.add(Integer.parseInt(sem2));
                socialWork.add(Integer.parseInt(sem3));
                socialWork.add(Integer.parseInt(sem4));
                socialWork.add(Integer.parseInt(sem5));
                socialWork.add(Integer.parseInt(sem6));
                socialWork.add(Integer.parseInt(sem7));
                socialWork.add(Integer.parseInt(sem8));
                socialWork.add(Integer.parseInt(sem9));
                socialWork.add(Integer.parseInt(sem10));
                newModel.addStudent(nameParts, group, socialWork);
                toNulls();
            }
        }

        private void toNulls() {
            firstName = null;
            secondName = null;
            fatherName = null;
            group = null;
            sem1 = null;
            sem2 = null;
            sem3 = null;
            sem4 = null;
            sem5 = null;
            sem6 = null;
            sem7 = null;
            sem8 = null;
            sem9 = null;
            sem10 = null;
        }
    }
}
