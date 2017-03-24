import org.junit.*;
import static org.junit.Assert.*;
import java.io.Console;



public class TeamTest{

  @Test
  public void teamInstantiatesCorrectly_True(){
    Team testTeam = new Team("Team","Goal");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void testTeamReturnsInputs_TeamGoal(){
    Team testTeam = new Team("Team","Goal");
    assertEquals( "Team", testTeam.getTeamName() );
    Team testTeam2 = new Team("Team","Goal");
    assertEquals( "Goal", testTeam2.getTeamGoal() );
  }

  @Test
  public void getId_TeamsInstantiateWithAnID_1(){
    Team.clear();
    Team myTeam = new Team("Team","Goal");
    assertEquals(1, myTeam.getId());
    System.out.println(myTeam.getId());
  }

}
