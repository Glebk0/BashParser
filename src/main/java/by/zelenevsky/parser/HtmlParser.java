package by.zelenevsky.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;

import java.io.IOException;

public class HtmlParser {

    private static void writeNote(String path, String text){
        try {
            FileWriter note = new FileWriter(path, true);
            note.write(text);
            note.flush();
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
    }

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://bash.im").get();
        Elements textElements = doc.select("div.text");
        Elements rating = doc.select("span.rating-o");
        String pathToFile = "src/main/java/by/zelenevsky/parser/notes.txt";
        for (int i = 0; i < textElements.size(); i++) {
            try{
                int ratingValue = Integer.parseInt(rating.get(i).text());
                if (ratingValue > 1000) {
                    String text = rating.get(i).text() + " " + textElements.get(i).text() + "\n\n";
                    writeNote(pathToFile, text);
                }
            } catch (NumberFormatException e){}
        }
    }
}
