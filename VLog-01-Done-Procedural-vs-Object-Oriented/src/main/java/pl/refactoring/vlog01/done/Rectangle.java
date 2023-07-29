package pl.refactoring.vlog01.done;

/**
 * Sources provided under artistic license
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
