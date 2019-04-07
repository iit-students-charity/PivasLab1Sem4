package lab2.controller;

import lab2.model.StudentEntity;
import org.w3c.dom.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLSaveComponent {
    private String filePath;
    private List<StudentEntity> students;

    public XMLSaveComponent(String filePath, List<StudentEntity> students) {
        this.filePath = filePath;
        this.students = students;
    }

    public void writeToFile() {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element root = document.createElement("students");
            document.appendChild(root);
            for (StudentEntity studentEntity : this.students) {
                Element student = document.createElement("student");
                root.appendChild(student);

                Element studentFullName = document.createElement("studentFullName");
                student.appendChild(studentFullName);

                List<String> nameParts = studentEntity.getNameParts();

                Element secondName = document.createElement("secondName");
                secondName.appendChild(document.createTextNode(nameParts.get(0)));
                studentFullName.appendChild(secondName);

                Element firstName = document.createElement("firstName");
                firstName.appendChild(document.createTextNode(nameParts.get(1)));
                studentFullName.appendChild(firstName);

                Element fatherName = document.createElement("fatherName");
                fatherName.appendChild(document.createTextNode(nameParts.get(2)));
                studentFullName.appendChild(fatherName);

                Element group = document.createElement("studentGroup");
                group.appendChild(document.createTextNode(studentEntity.getGroup()));
                student.appendChild(group);

                List<Integer> work = studentEntity.getHoursData();

                Element socialWork = document.createElement("socialWork");
                student.appendChild(socialWork);

                Element sem1 = document.createElement("sem1");
                sem1.appendChild(document.createTextNode(work.get(0).toString()));
                socialWork.appendChild(sem1);
                Element sem2 = document.createElement("sem2");
                sem2.appendChild(document.createTextNode(work.get(1).toString()));
                socialWork.appendChild(sem2);
                Element sem3 = document.createElement("sem3");
                sem3.appendChild(document.createTextNode(work.get(2).toString()));
                socialWork.appendChild(sem3);
                Element sem4 = document.createElement("sem4");
                sem4.appendChild(document.createTextNode(work.get(3).toString()));
                socialWork.appendChild(sem4);
                Element sem5 = document.createElement("sem5");
                sem5.appendChild(document.createTextNode(work.get(4).toString()));
                socialWork.appendChild(sem5);
                Element sem6 = document.createElement("sem6");
                sem6.appendChild(document.createTextNode(work.get(5).toString()));
                socialWork.appendChild(sem6);
                Element sem7 = document.createElement("sem7");
                sem7.appendChild(document.createTextNode(work.get(6).toString()));
                socialWork.appendChild(sem7);
                Element sem8 = document.createElement("sem8");
                sem8.appendChild(document.createTextNode(work.get(7).toString()));
                socialWork.appendChild(sem8);
                Element sem9 = document.createElement("sem9");
                sem9.appendChild(document.createTextNode(work.get(8).toString()));
                socialWork.appendChild(sem9);
                Element sem10 = document.createElement("sem10");
                sem10.appendChild(document.createTextNode(work.get(9).toString()));
                socialWork.appendChild(sem10);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File(filePath));
                transformer.transform(domSource, streamResult);
            }
        } catch (ParserConfigurationException pce) {
            JOptionPane.showMessageDialog(null, "If only I knew what went wrong");
        } catch (TransformerException tce) {
            JOptionPane.showMessageDialog(null, "wtf");
        }


    }
}
