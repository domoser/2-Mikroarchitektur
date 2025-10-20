package at.itkolleg.Decorator_HTML;

// Konkrete Komponente
class PlainText implements IText {
    private String content;

    public PlainText(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return content;
    }
}