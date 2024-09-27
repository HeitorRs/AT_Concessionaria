package info.heitor.concessionaria_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.heitor.concessionaria_service.controller.VeiculoController;
import info.heitor.concessionaria_service.model.Veiculo;
import info.heitor.concessionaria_service.service.VeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private VeiculoService veiculoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Veiculo veiculo;


    @BeforeEach
    public void setUp() {
        veiculo = new Veiculo();
        veiculo.setMarca("Fiat");
        veiculo.setModelo("Mobi");
        veiculo.setPlaca("ABC1234");
        veiculo.setAno("2022");

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAdicionarVeiculo() throws Exception {
        when(veiculoService.adicionarVeiculo(any(Veiculo.class))).thenReturn(veiculo);

        mockMvc.perform(post("/veiculos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa").value("ABC1234"))
                .andExpect(jsonPath("$.marca").value("Fiat"))
                .andExpect(jsonPath("$.modelo").value("Mobi"))
                .andExpect(jsonPath("$.ano").value("2022"));
    }

    @Test
    public void testListarVeiculos() throws Exception {
        List<Veiculo> veiculos = Collections.singletonList(veiculo);
        when(veiculoService.listarVeiculos()).thenReturn(veiculos);

        mockMvc.perform(get("/veiculos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].placa").value("ABC1234"))
                .andExpect(jsonPath("$[0].marca").value("Fiat"));
    }

    @Test
    public void testBuscarVeiculo() throws Exception {
        when(veiculoService.buscarVeiculoPorId(1L)).thenReturn(Optional.of(veiculo));

        mockMvc.perform(get("/veiculos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.placa").value("ABC1234"));
    }

    @Test
    public void testAtualizarVeiculo() throws Exception {
        when(veiculoService.atualizarVeiculo(eq(1L), any(Veiculo.class))).thenReturn(veiculo);

        mockMvc.perform(put("/veiculos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa").value("ABC1234"));
    }

    @Test
    public void testDeletarVeiculo() throws Exception {
        doNothing().when(veiculoService).deletarVeiculo(1L);

        mockMvc.perform(delete("/veiculos/1"))
                .andExpect(status().isNoContent());
    }
}