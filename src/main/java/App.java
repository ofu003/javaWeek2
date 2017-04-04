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
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:mId/members/new", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":mId")));
      // changed newTeamSingular to team
      model.put("team",team);
      model.put("template","templates/team-members-form.vtl");
      return new ModelAndView( model, layout);
    }, new VelocityTemplateEngine());

    get("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.all());
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/members", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Team findId = Team.find(Integer.parseInt(request.params("teamId")));
      // get user input from form
      String name = request.queryParams("name");
      String skills = request.queryParams("skills");
      Member newMember = new Member(name, skills);
      team.addAMember(newMember);
      model.put("team",team);
      model.put("template","templates/team-member-success.vtl");
      return new ModelAndView( model, layout);
    }, new VelocityTemplateEngine());

    get("/members/:mId", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Member member = Member.find(Integer.parseInt(request.params(":mId")));
      model.put("member", member);
      model.put("template","templates/member.vtl");
      return new ModelAndView( model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      // get user input from form to make a newTeam
      String name = request.queryParams("name");
      String goal = request.queryParams("goal");
      Team newTeam = new Team("name","goal");
      model.put("template", "templates/team-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // Display specific member belonging to a team
    

      // get("/Teams/:team_id/:members/:member_id", (request, response)->{
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   Team findId = Team.find(Integer.parseInt(request.params(":mId")));
      //
      //   model.put("newTeamSingular",findId);
      //   model.put("template","templates/AddMembers.vtl");
      //   return new ModelAndView( model, layout);
      // }, new VelocityTemplateEngine());



  }
}
