package alura.hub.foro.controller;

import alura.hub.foro.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CreacionDeTopicos creacionDeTopicos;

    @PostMapping
    public ResponseEntity registrarComentario(@RequestBody @Valid DatosCreacionComentario datosComentario,
                                              UriComponentsBuilder uriComponentsBuilder){
        var detallesTopico = creacionDeTopicos.crear(datosComentario);
        Topico topico = new Topico(detallesTopico);
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(detallesTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listarTopicos(@PageableDefault Pageable paginacion){
        var datos = topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new);
        return ResponseEntity.ok(datos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizadoTopico datosActualizadoTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizadoTopico.id());
        topico.actualizarDatos(datosActualizadoTopico);
        return ResponseEntity.ok(new DatosDetalleTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion()
        ,topico.getAutor()));
    }

    @PutMapping("/solucionado/{id}")
    @Transactional
    public ResponseEntity actualizarTopicoResuelto(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarSolucionado();
        return ResponseEntity.ok(new DatosDetalleTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion()
                ,topico.getAutor()));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
    
}
