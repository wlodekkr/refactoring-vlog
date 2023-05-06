package pl.refactoring.tutor;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}
