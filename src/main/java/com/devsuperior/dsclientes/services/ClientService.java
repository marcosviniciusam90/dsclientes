package com.devsuperior.dsclientes.services;

import com.devsuperior.dsclientes.dto.ClientDTO;
import com.devsuperior.dsclientes.entities.Client;
import com.devsuperior.dsclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> pageList = clientRepository.findAll(pageRequest);
        return pageList.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with ID %s not found", id)));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO create(ClientDTO clientDTO) {
        Client client = new Client(clientDTO);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client previousClient = clientRepository.getOne(id);

        Client client = new Client(clientDTO);
        client.setId(previousClient.getId());
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException(String.format("Entity with ID %s not found", id));
        }
    }
}
