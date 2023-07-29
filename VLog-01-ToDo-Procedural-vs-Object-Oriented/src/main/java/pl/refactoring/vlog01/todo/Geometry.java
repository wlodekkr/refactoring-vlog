package pl.refactoring.vlog01.todo;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class Geometry {
    public static double area(Object shape){
        if (shape instanceof Circle){
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        }
        if (shape instanceof Rectangle){
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.width * rectangle.height;
        }
        if (shape instanceof Square){
            Square square = (Square) shape;
            return square.size * square.size;
        }

        throw new IllegalArgumentException("Unknown shape provided");
    }
}
