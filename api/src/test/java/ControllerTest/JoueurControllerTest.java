package ControllerTest;

import com.example.api.controllers.JoueurController;
import com.example.api.model.Equipe;
import com.example.api.model.Joueur;
import com.example.api.repository.JoueurRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class JoueurControllerTest {

    @Mock
    private JoueurRepository joueurRepository;

    @InjectMocks
    private JoueurController joueurController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test unitaire pour créer un joueur ")
    public void testAddJoueur() {
        Long equipeId = 1L;
        Equipe equipeA = new Equipe("om", "Marseille", "marseille_logo.png");
        equipeA.setId(equipeId);
        Joueur joueur = new Joueur("John", "Doe", equipeId);
    }
}
