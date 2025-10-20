package at.itkolleg.Decorator_HTML;

// Fett-Dekorator
class BoldDecorator extends TextDecorator {
    public BoldDecorator(IText inner) {
        super(inner);
    }

    @Override
    public String render() {
        return "<b>" + super.render() + "</b>";
    }


}
