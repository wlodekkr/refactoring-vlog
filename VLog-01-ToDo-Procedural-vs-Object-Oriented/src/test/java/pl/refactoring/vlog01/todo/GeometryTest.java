package pl.refactoring.vlog01.todo;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class GeometryTest {
    @Test
    public void circleAreaWorksCorrectly() {
        // Given
        Circle circle = new Circle();
        circle.radius = 3;

        // When/Then
        assertThat(Geometry.area(circle))
                .isEqualTo(28.27, Offset.offset(0.01));
    }

    @Test
    public void rectangleAreaWorksCorrectly() {
        // Given
        Rectangle rectangle = new Rectangle();
        rectangle.height = 3;
        rectangle.width = 4;

        // When/Then
        assertThat(Geometry.area(rectangle))
                .isEqualTo(12);
    }

    @Test
    public void squareAreaWorksCorrectly() {
        // Given
        Square square = new Square();
        square.size = 5;

        // When/Then
        assertThat(Geometry.area(square))
                .isEqualTo(25);
    }
}
