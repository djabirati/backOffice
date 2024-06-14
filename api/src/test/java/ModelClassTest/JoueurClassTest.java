package ModelClassTest;

import com.example.api.model.Equipe;
import com.example.api.model.Joueur;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class JoueurClassTest {
    String nomJoueur;
    String prenomJoueur;
    Equipe equipe1;
    @BeforeEach
    public void setUp() {
        String nomJoueur = "Hakimi";
        String prenomJoueur = "Achraf";
        Equipe equipe1 = new Equipe("PSG", "Paris", "psg_logo.png");
    }
    @Test
    @DisplayName("Test constructeur et getter joueur")
    public void testJoueurConstructorAndGetter() {
        Joueur joueur = new Joueur(nomJoueur, prenomJoueur, equipe1);

        assertEquals(nomJoueur, joueur.getNom());
        assertEquals(prenomJoueur, joueur.getPrenom());
        assertEquals(equipe1, joueur.getEquipe());

    }

    @Test
    @DisplayName("test setter joueur")
    public void testJoueurSetter() {
        Joueur joueur = new Joueur(nomJoueur, prenomJoueur, equipe1);

        Equipe equipe2 = new Equipe("Real Madrid", "Madrid", "rm_logo.png");
        joueur.setNom(nomJoueur);
        joueur.setPrenom(prenomJoueur);
        joueur.setEquipe(equipe2);

        assertEquals(nomJoueur, joueur.getNom());
        assertEquals(prenomJoueur, joueur.getPrenom());
        assertEquals(equipe2, joueur.getEquipe());

    }
}
