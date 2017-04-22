/**
 * Created by hasun on 17. 4. 22.
 */
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class myHandler extends DefaultHandler {

    //List to hold Employees object
    private List<wikiModel> wikiList = null;
    private wikiModel wikiModel = null;


    //getter method for employee list
    public List<wikiModel> getWikiList() {
        return wikiList;
    }

    boolean bTitle = false;
    boolean bText = false;
    int count = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("page")) {
            //create a new Employee and put it in Map
            String id = "";
            wikiModel = new wikiModel();
            if (qName.equalsIgnoreCase("id")) {
                id = attributes.getValue("id");
                wikiModel.setId(Integer.parseInt(id));
            }else {
                count++;
                wikiModel.setId(count);
            }
            //initialize Employee object and set id attribute
//            wikiModel = new wikiModel();
//            wikiModel.setId(Integer.parseInt(id));
            //initialize list
            if (wikiList == null)
                wikiList = new ArrayList<wikiModel>();
        } else if (qName.equalsIgnoreCase("title")) {
            //set boolean values for fields, will be used in setting Employee variables
            bTitle = true;
        } else if (qName.equalsIgnoreCase("text")) {
            bText = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("page")) {
            //add Employee object to list
            wikiList.add(wikiModel);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bTitle) {
            //age element, set Employee age
            wikiModel.setTitle(new String(ch, start, length));
            bTitle = false;
        } else if (bText) {
            wikiModel.setText(new String(ch, start, length));
            bText = false;
        }
    }
}
