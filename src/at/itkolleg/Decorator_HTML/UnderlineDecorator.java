package at.itkolleg.Decorator_HTML;

// Unterstrichen-Dekorator
class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(IText inner) {
        super(inner);
    }

    @Override
    public String render() {
        return "<u>" + super.render() + "</u>";
    }
}
