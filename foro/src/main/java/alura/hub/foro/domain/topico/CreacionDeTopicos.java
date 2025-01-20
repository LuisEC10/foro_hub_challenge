package alura.hub.foro.domain.topico;

import alura.hub.foro.domain.curso.CursoRepository;
import alura.hub.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreacionDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosDetalleTopico crear(DatosCreacionComentario datosCreacionComentario){
        var usuario = usuarioRepository.findById(datosCreacionComentario.idUsuario()).get();
        var curso = cursoRepository.findById(datosCreacionComentario.idCurso()).get();
        var topico = new Topico(null, datosCreacionComentario.titulo(), datosCreacionComentario.mensaje(), datosCreacionComentario.fechaCreacion(),
                usuario.getNombre(),curso);
        var topicoRespuesta = new Topico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getAutor());
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topicoRespuesta);
    }

}
