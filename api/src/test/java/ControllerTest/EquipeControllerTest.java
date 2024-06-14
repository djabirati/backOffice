package ControllerTest;

import com.example.api.controllers.EquipeController;
import com.example.api.model.Equipe;
import com.example.api.repository.EquipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class EquipeControllerTest {

    @Mock
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeController equipeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllEquipes() {

        Equipe equipe1 = new Equipe("om", "Marseille", "marseille_logo.png");
        Equipe equipe2 = new Equipe("psg", "Paris", "psg_logo.png");

        List<Equipe> equipeList = Arrays.asList(equipe1, equipe2);

        when(equipeRepository.findAll()).thenReturn(equipeList);

        ResponseEntity<List<Equipe>> response = equipeController.getAllEquipes();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(equipeList, response.getBody());
        assertEquals(equipe1, response.getBody().get(0));
        assertEquals(equipe2, response.getBody().get(1));
    }

   @Test
    public void testAddEquipes() {
        Equipe equipe = new Equipe("om", "Marseille", "marseille_logo.png");
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);
        ResponseEntity<Equipe> response = equipeController.addEquipe(equipe);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(equipe, response.getBody());
    }

    @Test
    public void testUpdateEquipes() {

        Long id = 1L;
        Equipe equipe = new Equipe("om", "Marseille", "marseille_logo.png");
        equipe.setId(id);
        Equipe equipeModifie = new Equipe("om", "Marseille", "om_logo.png");

        when(equipeRepository.findById(id)).thenReturn(Optional.of(equipe));
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipeModifie);

        ResponseEntity<Equipe> response = equipeController.updateEquipe(id, equipeModifie);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(equipeModifie.getNom(), response.getBody().getNom());
        assertEquals(equipeModifie.getVille(), response.getBody().getVille());
        assertEquals(equipeModifie.getLogo(), response.getBody().getLogo());

        verify(equipeRepository, times(1)).findById(eq(id));
        verify(equipeRepository, times(1)).save(any(Equipe.class));

    }


}
