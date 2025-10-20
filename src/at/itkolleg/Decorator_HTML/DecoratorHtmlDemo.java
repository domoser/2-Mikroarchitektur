package at.itkolleg.Decorator_HTML;

import java.io.FileWriter;
import java.io.IOException;

// Hauptklasse
public class DecoratorHtmlDemo {
    public static void main(String[] args) {

        IText text = new ItalicDecorator(
                //new ItalicDecorator(
                        new UnderlineDecorator(
                                new UnderlineDecorator(
                                    new PlainText("Hallo Welt!")
                                    )
                        )
                //)
        );

        String htmlContent = """
            <!DOCTYPE html>
            <html lang="de">
            <head>
                <meta charset="UTF-8">
                <title>Decorator Pattern Beispiel</title>
            </head>
            <body>
                <p>%s</p>
            </body>
            </html>
            """.formatted(text.render());

        try (FileWriter writer = new FileWriter("./src/at/itkolleg/Decorator_HTML/decorator_output.html")) {
            writer.write(htmlContent);
            System.out.println("HTML-Datei erfolgreich erstellt: decorator_output.html");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }
}
