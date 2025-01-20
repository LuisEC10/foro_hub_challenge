package alura.hub.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String nombre,
        String mensaje,
        String autor,
        LocalDateTime fechaCreacion
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getFechaCreacion());
    }
}
