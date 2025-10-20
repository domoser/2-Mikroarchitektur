package at.itkolleg.Decorator_HTML;

// Basisklasse für Decorators
abstract class TextDecorator implements IText {
    protected IText inner;

    public TextDecorator(IText inner) {
        this.inner = inner;
    }

    @Override
    public String render() {
        return inner.render();
    }
}