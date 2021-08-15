import java.util.Map;

import model.Hero;
import model.SQUAD;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
@@ -11,11 +12,17 @@
public static void main(String[] args) { //type “psvm + tab” to autocreate this
        staticFileLocation("/public");

        //SQUAD squad1 = new SQUAD();

        //get: show all tasks
        get("/", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        ArrayList<Hero> heros = Hero.getAll();
        model.put("heros", heros);

        ArrayList<SQUAD> squads= SQUAD.getAll();
        model.put("squads", squads);

        return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

@@ -33,7 +40,13 @@ public static void main(String[] args) { //type “psvm + tab” to autocreate t
        Integer age = Integer.parseInt(stringAge);
        String specialPower = req.queryParams("specialPower");
        String weakness = req.queryParams("weakness");
        Hero newHero = new Hero(name,age,specialPower,weakness);
        String yourSquad = req.queryParams("squadName");

        Hero newHero = new Hero(name,age,specialPower,weakness,yourSquad);

        String squadName = req.queryParams("squadName");
        SQUAD newSquad = new SQUAD(squadName,newHero);

        res.redirect("/");
        return null;
        }, new HandlebarsTemplateEngine());