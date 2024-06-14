package ModelClassTest;

import com.example.api.model.Equipe;
import com.example.api.model.Joueur;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class JoueurClassTest {

    @Test
    @DisplayName("Test constructeur et getter joueur")
    public void testJoueurConstructorAndGetter() {

        String nomJoueur = "Hakimi";
        String prenomJoueur = "Achraf";

        Equipe equipe = new Equipe("PSG", "Paris", "psg_logo.png");
        Joueur joueur = new Joueur(nomJoueur, prenomJoueur, equipe);

        assertEquals(nomJoueur, joueur.getNom());
        assertEquals(prenomJoueur, joueur.getPrenom());
        assertEquals(equipe, joueur.getEquipe());

    }

    @Test
    @DisplayName("test setter joueur")
    public void testJoueurSetter() {

        String nomJoueur = "Hakimi";
        String prenomJoueur = "Achraf";
        Equipe equipe1 = new Equipe("PSG", "Paris", "psg_logo.png");
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
