package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tarefa")
public interface TarefaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaIdResponse postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);

    @GetMapping("/{idTarefa}")
    @ResponseStatus(code = HttpStatus.OK)
    TarefaDetalhadoResponse detalhaTarefa(@RequestHeader(name = "Authorization",required = true) String token, 
    		@PathVariable UUID idTarefa);


    @PatchMapping("/{idTarefa}")
    @ResponseStatus(code = HttpStatus.OK)
    void alteraTarefa(@RequestBody @Valid TarefaAlteracaoRequest tarefaAlteracaoRequest, @PathVariable UUID idTarefa);

    @DeleteMapping("/{idTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaTarefa(@PathVariable UUID idTarefa);

    
}
