package ModelClassTest;


import com.example.api.model.Equipe;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class EquipeClassTest {

    @Test
    @DisplayName("Test constructeur et getter equipe")
    public void testEquipeConstructorAndGetters(){
        String nom = "OM";
        String ville = "Marseille";
        String logo = "marseille_logo.png";

        Equipe equipe = new Equipe(nom, ville, logo);

        assertEquals(nom, equipe.getNom());
        assertEquals(ville, equipe.getVille());
        assertEquals(logo, equipe.getLogo());
    }

    @Test
    @DisplayName("Test setter equipe")
    public void testSetterEquipe(){
        String nom = "OM";
        String ville = "Marseille";
        String logo = "marseille_logo.png";
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
