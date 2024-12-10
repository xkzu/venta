package cl.duoc.app.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class VentaDTO {
    private Long id; // ID de la venta
    private Long usuarioId; // ID del usuario asociado
    private String productos; // Resumen de productos comprados
    private LocalDateTime fecha; // Fecha de la venta
    private BigDecimal total; // Total de la venta
}