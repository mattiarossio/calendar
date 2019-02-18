/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circolarexml;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {
    

    private List elemento;

    public Parser() {
        elemento = new ArrayList();
    }

    public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;

        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();

        CircolareXML circolareXML;
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                circolareXML = EsaminaElemento(element);
                if (circolareXML != null) {
                    elemento.add(circolareXML);
                }
            }
        }
        return elemento;
    }

    private CircolareXML EsaminaElemento(Element element) {
        Element elementTD;
        NodeList nodelist = element.getElementsByTagName("td");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elementTD = (Element) nodelist.item(i);
                if (elementTD.getFirstChild() != null) {
                    String testo = elementTD.getFirstChild().getNodeValue();
                    System.out.println("EsaminaElemento: " + testo);
                } else {
                    System.out.println("EsaminaElemento: ");
                }
            }
        }
        /*      
        CircolareXML circolareXML;
        String disciplina =getTextValue(element, "td");
        String docente = getTextValue(element, "td");
        String giorno = getTextValue(element, "td");
        float ora = getFloatValue(element, "td");
        circolareXML = new CircolareXML(disciplina, docente, giorno, ora);
         */
        return null;
    }

    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag) {
        String value = null;
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        if (nodelist != null && nodelist.getLength() > 0) {
            value = nodelist.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    // restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }

    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }

}
