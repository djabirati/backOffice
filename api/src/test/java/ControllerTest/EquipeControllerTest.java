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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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

  /*  @Test
    public void testAddEquipes() {
        Equipe equipe = new Equipe("om", "Marseille", "marseille_logo.png");


    }*/


}
