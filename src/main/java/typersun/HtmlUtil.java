package typersun;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HtmlUtil {

    public static void SaveHtmlByUrl(String url) throws IOException {
        String FILENAME = Main.path;
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
        URL myurl = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
        InputStream ins = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(ins, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(isr);
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            bw.write(inputLine);
        }
        in.close();
        bw.close();
    }

    public static String extractText() throws IOException, BadLocationException {
        EditorKit kit = new HTMLEditorKit();
        Document doc = kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        Reader rd = new FileReader(Main.path);
        kit.read(rd, doc, 0);
        return doc.getText(0, doc.getLength());
    }
}