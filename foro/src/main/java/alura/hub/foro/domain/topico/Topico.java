package alura.hub.foro.domain.topico;

import alura.hub.foro.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    private String autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(Long id, String titulo, String mensaje, LocalDateTime localDateTime, String nombre, Curso curso) {
        this.status = true;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = localDateTime;
        this.autor = nombre;
        this.curso = curso;
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
    }

    public Topico(DatosDetalleTopico detallesTopico) {
        this.titulo = detallesTopico.titulo();
        this.mensaje = detallesTopico.mensaje();
        this.fechaCreacion = detallesTopico.fechaCreacion();
        this.autor = detallesTopico.autor();
    }

    public void actualizarDatos(DatosActualizadoTopico datosActualizadoTopico){
        if(datosActualizadoTopico.nuevoTitulo() != null){
            this.titulo = datosActualizadoTopico.nuevoTitulo();
        }
        if(datosActualizadoTopico.nuevoMensaje() != null){
            this.mensaje = datosActualizadoTopico.nuevoMensaje();
        }
    }

    public void actualizarSolucionado() {
        this.titulo = "(SOLUCIONADO) " + this.getTitulo();
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
