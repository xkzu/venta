package cl.duoc.app.controller;

import cl.duoc.app.dto.VentaDTO;
import cl.duoc.app.model.Venta;
import cl.duoc.app.service.VentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VentaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VentaService ventaService;

    @InjectMocks
    private VentaController ventaController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ventaController).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Registrar soporte para JavaTime
    }

    @Test
    void testAddVentaSuccess() throws Exception {
        // Arrange
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(1L);
        ventaDTO.setUsuarioId(10L);
        ventaDTO.setProductos("Producto1,Producto2");
        ventaDTO.setFecha(LocalDateTime.now());
        ventaDTO.setTotal(BigDecimal.valueOf(1234.56));

        Venta venta = new Venta();
        venta.setId(1L);
        venta.setUsuarioId(10L);
        venta.setProductos("Producto1,Producto2");
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(BigDecimal.valueOf(1234.56));

        when(ventaService.add(any(Venta.class))).thenReturn(venta);

        // Act & Assert
        mockMvc.perform(post("/venta/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ventaDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void testAddVentaInternalServerError() throws Exception {
        // Arrange
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(1L);
        ventaDTO.setUsuarioId(10L);
        ventaDTO.setProductos("Producto1,Producto2");
        ventaDTO.setFecha(LocalDateTime.now());
        ventaDTO.setTotal(BigDecimal.valueOf(1234.56));

        when(ventaService.add(any(Venta.class))).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        mockMvc.perform(post("/venta/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ventaDTO)))
                .andExpect(status().isInternalServerError());
    }

}
