package ModelClassTest;

import com.example.api.model.Equipe;
import com.example.api.model.Match;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MatchClassTest {
    Date date;
    String lieu;
    Equipe om;
    Equipe psg;
    int scoreA;
    int scoreB;

    @BeforeEach
    public void setUp() {
        LocalDate localDate1 = LocalDate.of(2024, 8, 20);
        Date date = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String lieu = "Stade Vélodrome";
        Equipe om = new Equipe("OM", "Marseille", "marseille_logo.png");
        Equipe psg = new Equipe("PSG", "Paris", "psg_logo.png");
        int scoreA = 2;
        int scoreB = 0;


    }
    @Test
    @DisplayName("Test getter et constructor match")
    public void testMatchConstructorAndGetters(){
        Match match = new Match(date, lieu, om, psg, scoreA, scoreB);

        assertEquals(date, match.getDate());
        assertEquals(lieu, match.getLocation());
        assertEquals(om, match.getTeamA());
        assertEquals(psg, match.getTeamB());
        assertEquals(scoreA, match.getScoreA());
        assertEquals(scoreB, match.getScoreB());
    }

    @Test
    @DisplayName("Test setter match")
    public void testSetterMatch(){
        LocalDate localDate1 = LocalDate.of(2024, 8, 28);
        Date nouvelleDate = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String nouveauLieu = "PArc des Princes";
        Match match = new Match(date, lieu, om, psg, scoreA, scoreB);
        match.setDate(nouvelleDate);
        match.setLocation(nouveauLieu);

        assertEquals( nouvelleDate, match.getDate());
        assertEquals(nouveauLieu, match.getLocation());
        assertEquals(om, match.getTeamA());
        assertEquals(psg, match.getTeamB());
        assertEquals(scoreA, match.getScoreA());
        assertEquals(scoreB, match.getScoreB());
    }
}
