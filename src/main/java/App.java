import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Date;
import java.util.*;
import java.text.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("places", request.session().attribute("places"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/places", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Place> places = request.session().attribute("places");
      if (places == null) {
        places = new ArrayList<Place>();
        request.session().attribute("places", places);
      }

      String country = request.queryParams("country");
      String city = request.queryParams("city");
      String mainAttraction = request.queryParams("mainAttraction");
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
      Date date;
      date = ft.parse(request.queryParams("date"));
      // Date date = Date.parse(request.queryParams("date"));
      Place newPlace = new Place(country, city, mainAttraction, date);
      places.add(newPlace);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
  }
}
