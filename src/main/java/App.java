import java.io.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main (String[] args){
    //staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // "any extra info the template needs must be packaged in model"
      model.put("newMemberKey", request.session().attribute("newMemberKey"));
      model.put("newTeamKey", request.session().attribute("newTeamKey"));
      // "FOR HOME PAGE, PARSE INDEX.VTL INTO $TEMPLATE"
      model.put("template", "templates/index.vtl");
      // USE THE LAYOUT.VTL AS TEMPLATE
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/showMembers", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Member> Members = request.session().attribute("newMemberKey");
      if (Members == null) {
        Members = new ArrayList<Member>();
        request.session().attribute("newMemberKey", Members );
      }
      // Get input value from index file, store as variable in App.java
      String name = request.queryParams("memberName");
      String skills = request.queryParams("memberSkills");
      // Construct  object using those variables
      Member newMember = new Member( name, skills );

      Members.add(newMember);
      // new member needs to be put into model
      model.put("Member", newMember);
      model.put("template", "templates/showMembers.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/showTeams", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Team> Teams = request.session().attribute("newTeamKey");
      if (Teams == null) {
        Teams = new ArrayList<Team>();
        request.session().attribute("newTeamKey", Teams );
      }
      // Get input value from index file, store as variable in App.java
      String teamName = request.queryParams("teamName");
      String teamGoal = request.queryParams("teamGoal");
      // Construct  object using those variables
      Team newTeam = new Team( teamName, teamGoal );

      Teams.add( newTeam );
      // new member needs to be put into model
      model.put("Team", newTeam);
      model.put("template", "templates/showTeams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
