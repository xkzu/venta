package cl.duoc.app.service;

import cl.duoc.app.model.Venta;
import cl.duoc.app.repository.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VentaServiceImplTest {

    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    private VentaServiceImpl ventaService;

    private Venta venta;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        venta = new Venta();
        venta.setId(1L);
        venta.setUsuarioId(10L);
        venta.setProductos("Producto1, Producto2");
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(new BigDecimal("1234.56"));
    }

    @Test
    void testAdd() {
        when(ventaRepository.save(any(Venta.class))).thenReturn(venta);

        Venta result = ventaService.add(venta);

        assertNotNull(result);
        assertEquals(venta.getId(), result.getId());
        assertEquals(venta.getUsuarioId(), result.getUsuarioId());
        assertEquals(venta.getProductos(), result.getProductos());
        assertEquals(venta.getFecha(), result.getFecha());
        assertEquals(venta.getTotal(), result.getTotal());

        verify(ventaRepository, times(1)).save(venta);
    }

    @Test
    void testAddNullVenta() {
        // Configuramos el mock para lanzar una excepción si se intenta guardar un objeto null
        doThrow(new IllegalArgumentException("Venta no puede ser null")).when(ventaRepository).save(null);

        // Verificamos que se lanza la excepción al intentar agregar una venta nula
        assertThrows(IllegalArgumentException.class, () -> ventaService.add(null), "Se esperaba una excepción al agregar una venta nula");

        // Verificamos que el método save nunca sea llamado con un argumento válido
        verify(ventaRepository, never()).save(any(Venta.class));
    }

}
