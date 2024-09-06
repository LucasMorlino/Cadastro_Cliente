package application.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    
    public ClienteDTO criar(ClienteDTO ClienteDTO) {
        Cliente Cliente = new Cliente();
        Cliente.setNome(ClienteDTO.getNome());
        Cliente.setSobrenome(ClienteDTO.getSobrenome());
        Cliente.setIdade(ClienteDTO.getIdade());
        Cliente.setCpf(ClienteDTO.getCpf());
        Cliente.setTelefone(ClienteDTO.getTelefone());
        Cliente.setEmail(ClienteDTO.getEmail());
        Cliente.setEndereco(ClienteDTO.getEndereco());
        repository.save(Cliente);
        ClienteDTO.setId(Cliente.getId());
        return  ClienteDTO;
    }

    public ClienteDTO atualizar (ClienteDTO ClienteDTO, Long ClienteId) {
        Cliente ClienteDatabase = repository.getOne(ClienteId);
        ClienteDatabase.setNome(ClienteDTO.getNome());
        ClienteDatabase.setSobrenome(ClienteDTO.getSobrenome());
        ClienteDatabase.setIdade(ClienteDTO.getIdade());
        ClienteDatabase.setCpf(ClienteDTO.getCpf());
        ClienteDatabase.setTelefone(ClienteDTO.getTelefone());
        ClienteDatabase.setEmail(ClienteDTO.getEmail());
        ClienteDatabase.setEndereco(ClienteDTO.getEndereco());
        repository.save(ClienteDatabase);
        return ClienteDTO;
    }

    private ClienteDTO converter (Cliente cliente) {
        ClienteDTO result = new ClienteDTO();
        result.setId(cliente.getId());
        result.setNome(cliente.getNome());
        result.setSobrenome(cliente.getSobrenome());
        result.setIdade(cliente.getIdade());
        result.setCpf(cliente.getCpf());
        result.setTelefone(cliente.getTelefone());
        result.setEmail(cliente.getEmail());
        result.setEndereco(cliente.getEndereco());
        return result;
    }

    public List<ClienteDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long clienteId) {
        repository.deleteById(clienteId);
        return "DELETED";
    }


}
