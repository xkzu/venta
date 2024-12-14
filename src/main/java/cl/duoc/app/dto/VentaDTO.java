package cl.duoc.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Long id;
    private Long usuarioId;
    private String productos;
    private LocalDateTime fecha;
    private BigDecimal total;
}