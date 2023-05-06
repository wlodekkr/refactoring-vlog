package pl.refactoring.tutor;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class Square extends Shape {
    private float size;

    public Square(int size) {
        this.size = size;
    }

    @Override
    double calculateArea() {
        return size * size;

    }
}
