/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circolarexml;

/**
 *
 * @author Mattia_Rossi
 */
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class NBValidateXML {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        List Consigli = null;
        String fileXML = "xml\\Circolari_1419_2015-2016.140 Avvio Sportelli didattici - Integrazione (1).xml";
        Parser dom = new Parser();
        try {
            Consigli = dom.parseDocument(fileXML);
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        // iterazione della lista e visualizzazione degli oggetti
        System.out.println("Numero di consigli: " + Consigli.size());
        Iterator iterator = Consigli.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

    }
   
}