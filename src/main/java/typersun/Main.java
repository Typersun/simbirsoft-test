package typersun;

import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public final static String path = "c:" + File.separator + "temp" + File.separator + "filename.html";

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Укажите URL сайта в качестве аргумента.");
                return;
            }
            HtmlUtil.SaveHtmlByUrl((args[0]));
            String text = HtmlUtil.extractText();
            Counter.printResult(Counter.parseWords(text));
        } catch (BadLocationException e) {
            System.out.println("Проблема с чтением файла");
        } catch (IOException e) {
            System.out.println("Не удалось подключиться");
        } catch (IllegalArgumentException | ClassCastException e) {
            System.out.println("Неверный формат URL");
        }
    }
}
