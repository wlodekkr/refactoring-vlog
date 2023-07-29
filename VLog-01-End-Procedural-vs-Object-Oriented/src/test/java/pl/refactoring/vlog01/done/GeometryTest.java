package pl.refactoring.vlog01.done;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class GeometryTest {
    @Test
    public void circleAreaWorksCorrectly() {
        // Given
        Circle circle = new Circle(3);

        // When
        double area = circle.calculateArea();

        // Then
        assertThat(area)
                .isEqualTo(28.27, Offset.offset(0.01));
    }

    @Test
    public void rectangleAreaWorksCorrectly() {
        // Given
        Rectangle rectangle = new Rectangle(3, 4);

        // When
        double area = rectangle.calculateArea();

        // Then
        assertThat(area)
                .isEqualTo(12);
    }

    @Test
    public void squareAreaWorksCorrectly() {
        // Given
        Square square = new Square(5);

        // When
        double area = square.calculateArea();

        // Then
        assertThat(area)
                .isEqualTo(25);
    }
}
