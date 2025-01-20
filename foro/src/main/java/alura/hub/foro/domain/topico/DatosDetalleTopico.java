package alura.hub.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String autor) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor());
    }
}
