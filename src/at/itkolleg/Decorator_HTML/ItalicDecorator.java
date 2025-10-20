package at.itkolleg.Decorator_HTML;

// Kursiv-Dekorator
class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(IText inner) {
        super(inner);
    }

    @Override
    public String render() {
        return "<i>" + super.render() + "</i>";
    }
}

