import static org.junit.Assert.*;
import org.junit.*;

public class RectangleTest {
    @Test
    public void area_returnsTheAreaOfTheRectangle_450() throws Exception{
        Rectangle testRectangle = new Rectangle(15, 30);
        assertEquals(450, testRectangle.area());
    }
}
