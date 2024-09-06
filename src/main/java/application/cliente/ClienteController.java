package application.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE )
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseBody
    public ClienteDTO criar(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.criar(clienteDTO);
    }

    @PutMapping("/{clienteId}")
    @ResponseBody
    public ClienteDTO atualizar(@PathVariable("clienteId") Long clienteId,
                               @RequestBody ClienteDTO clienteDTO) {
        return clienteService.atualizar(clienteDTO, clienteId);
    }

    @GetMapping
    @ResponseBody
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();
    }

    @DeleteMapping("/{clienteId}")
    @ResponseBody
    public String deletar(@PathVariable("clienteId") Long clienteId) {
        return clienteService.delete(clienteId);
    }

}
