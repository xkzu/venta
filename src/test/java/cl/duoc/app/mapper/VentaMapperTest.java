package cl.duoc.app.mapper;

import cl.duoc.app.dto.VentaDTO;
import cl.duoc.app.model.Venta;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VentaMapperTest {

    @Test
    void testToDTO() {
        // Configuración
        Venta venta = new Venta();
        venta.setId(1L);
        venta.setUsuarioId(10L);
        venta.setProductos("Producto1, Producto2");
        venta.setFecha(LocalDateTime.of(2024, 12, 14, 15, 30));
        venta.setTotal(new BigDecimal("1500.75"));

        // Conversión
        VentaDTO dto = VentaMapper.toDTO(venta);

        // Verificación
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals(10L, dto.getUsuarioId());
        assertEquals("Producto1, Producto2", dto.getProductos());
        assertEquals(LocalDateTime.of(2024, 12, 14, 15, 30), dto.getFecha());
        assertEquals(new BigDecimal("1500.75"), dto.getTotal());
    }

    @Test
    void testToEntity() {
        // Configuración
        VentaDTO dto = new VentaDTO();
        dto.setId(1L);
        dto.setUsuarioId(10L);
        dto.setProductos("Producto3, Producto4");
        dto.setFecha(LocalDateTime.of(2024, 12, 14, 16, 0));
        dto.setTotal(new BigDecimal("2000.50"));

        // Conversión
        Venta venta = VentaMapper.toEntity(dto);

        // Verificación
        assertNotNull(venta);
        assertEquals(1L, venta.getId());
        assertEquals(10L, venta.getUsuarioId());
        assertEquals("Producto3, Producto4", venta.getProductos());
        assertEquals(LocalDateTime.of(2024, 12, 14, 16, 0), venta.getFecha());
        assertEquals(new BigDecimal("2000.50"), venta.getTotal());
    }

    @Test
    void testToDTOWithNullValues() {
        // Configuración
        Venta venta = new Venta();

        // Conversión
        VentaDTO dto = VentaMapper.toDTO(venta);

        // Verificación
        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getUsuarioId());
        assertNull(dto.getProductos());
        assertNull(dto.getFecha());
        assertNull(dto.getTotal());
    }

    @Test
    void testToEntityWithNullValues() {
        // Configuración
        VentaDTO dto = new VentaDTO();

        // Conversión
        Venta venta = VentaMapper.toEntity(dto);

        // Verificación
        assertNotNull(venta);
        assertNull(venta.getId());
        assertNull(venta.getUsuarioId());
        assertNull(venta.getProductos());
        assertNull(venta.getFecha());
        assertNull(venta.getTotal());
    }
}
