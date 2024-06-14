package ModelClassTest;


import com.example.api.model.Equipe;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class EquipeClassTest {
    String nom;
    String ville;
    String logo;

    @BeforeEach
    public void setUp() {
        String nom = "OM";
        String ville = "Marseille";
        String logo = "marseille_logo.png";
    }

    @Test
    @DisplayName("Test constructeur et getter equipe")
    public void testEquipeConstructorAndGetters(){
        Equipe equipe = new Equipe(nom, ville, logo);
        assertEquals(nom, equipe.getNom());
        assertEquals(ville, equipe.getVille());
        assertEquals(logo, equipe.getLogo());
    }

    @Test
    @DisplayName("Test setter equipe")
    public void testSetterEquipe(){
        Equipe equipe = new Equipe(nom, ville, logo);

        String nouveauNom = "PSG";
        String nouveauVille = "Paris";
        String nouveauLogo = "psg_logo.png";

        equipe.setNom(nouveauNom);
        equipe.setVille(nouveauVille);
        equipe.setLogo(nouveauLogo);

        assertEquals(nouveauNom, equipe.getNom());
        assertEquals(nouveauVille, equipe.getVille());
        assertEquals(nouveauLogo,equipe.getLogo());
    }




}
