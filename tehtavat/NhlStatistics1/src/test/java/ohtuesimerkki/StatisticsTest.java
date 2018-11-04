
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }  
    
@Test
public void etsiessaPalautetaanOikeaPelaaja(){
    assertTrue(stats.search("Semenko").getName() == "Semenko");
}


@Test
public void olematontaPelaajaEtsieassaPalautetaanNull(){
    assertTrue(stats.search("Ei ole") == null);
}

@Test
public void palautetaanOikeaListaJosOnPelaajia(){
    boolean isTrue = false;
    for(Player p : stats.team("EDM")){
        isTrue = p.getTeam() == "EDM" ? true : false;
    }
    assertTrue(isTrue);
}

@Test
public void palautetaanTyhjaListaJosEiOlePelaajia(){
    boolean isTrue = false;
    for(Player p : stats.team("eiOLe")){
        isTrue = p.getTeam() == "eiOle" ? true : false;
    }
    assertFalse(isTrue);
}

@Test
public void palautettaanOikeaTopScoreYhdella(){
    Player top = stats.topScorers(0).get(0);
    assertEquals(top.getName(),"Gretzky");
}

@Test
public void palautettaanTyhjaListaVirheellisellaTopScoreHaulla(){
    assertTrue(stats.topScorers(-1).isEmpty());
}

}
