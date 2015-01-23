package reivax.norac.samplewebbapp.xml;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by xavier caron on 22/01/2015.
 */
public abstract class XmlParser<T> {

    protected Digester digester = new Digester();

    protected abstract void addRules();

    public T parse(URL fileURL){
        this.addRules();
        T toReturn = null;

        try {
            toReturn = this.digester.parse(fileURL);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
