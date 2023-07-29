package pl.refactoring.vlog01.done;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class Circle extends Shape {
    private float radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
