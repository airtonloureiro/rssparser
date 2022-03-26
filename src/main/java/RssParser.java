import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class RssParser {

  public static void main(String[] args) {

    try {

      URL url = new URL("https://www.infowester.com/newsiw.rss");
      HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(httpURLConnection));
      List entries = feed.getEntries();
      Iterator itEntries = entries.iterator();

      while(itEntries.hasNext()) {
        SyndEntry entry = (SyndEntry) itEntries.next();
        System.out.println("");
        System.out.println("Titulo: " + entry.getTitle());
        System.out.println("Data de Publicação: " + entry.getPublishedDate());
        System.out.println("Link: " + entry.getLink());
      }


    } catch (MalformedURLException malformedURLException) {
      malformedURLException.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (FeedException e) {
      e.printStackTrace();
    }
  }

}