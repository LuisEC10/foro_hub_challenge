package alura.hub.foro.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizadoTopico(
        @NotNull
        Long id,
        String nuevoTitulo,
        String nuevoMensaje) {
}
