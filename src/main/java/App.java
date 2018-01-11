import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String[] args) {

        get("/", (req, res) -> {
            Map<String, ArrayList<Rectangle>> model = new HashMap<>();
            ArrayList myRectangleArrayList = Rectangle.getAll();
            model.put("myRectangles", myRectangleArrayList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/rectangles/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>(); // I may be different from your code to account for generic “Objects”
            int height = Integer.parseInt(req.queryParams("height"));
            int width = Integer.parseInt(req.queryParams("width"));
            Rectangle myRectangle = new Rectangle(height, width); //as we know this will automatically add itself to a list of all rectangles.
            model.put("myRectangle", myRectangle); //don’t forget me!

            if (myRectangle.getShape()) {
                Cube myCube = new Cube(myRectangle);
                model.put("myCube", myCube);
            }
            return new ModelAndView(model, "rectangle-detail.hbs"); //render a detail page instead of redirecting to home.
        }, new HandlebarsTemplateEngine());
        Rectangle.clearAllRectangles();
    }
}