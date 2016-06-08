package dataFromServer;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Neven on 8.6.2016..
 */

@Root(name = "note")
public class note {

    @Element(name = "to")
    String to;

    @Element(name = "from")
    String from;

    @Element(name = "heading")
    String heading;

    @Element(name = "body")
    String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
