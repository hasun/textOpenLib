import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by hasun on 17. 4. 22.
 */
public class xmlParserSax {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            myHandler handler = new myHandler();
            saxParser.parse(new File("/home/hasun/다운로드/kowiki-20170420-pages-articles.xml"), handler);
            //Get Employees list
            List<wikiModel> wikiList = handler.getWikiList();
            //print employee information
            for(wikiModel wiki : wikiList)
                System.out.println(wiki);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }catch (SAXException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
