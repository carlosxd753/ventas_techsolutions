package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.ClienteCreateDTO;
import com.techsolutions.ventas.dto.ClienteDTO;
import com.techsolutions.ventas.dto.ClienteUpdateDTO;
import com.techsolutions.ventas.enums.Estado;
import com.techsolutions.ventas.model.Cliente;
import com.techsolutions.ventas.repository.ClienteRepository;
import com.techsolutions.ventas.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(c -> new ClienteDTO(
                        c.getId(),
                        c.getNombre(),
                        c.getDni(),
                        c.getCelular(),
                        c.getFecha_creacion()
                ))
                .toList();
    }

    @Override
    public ClienteDTO obtenerPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el cliente con id: " + id));

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getDni(),
                cliente.getCelular(),
                cliente.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public ClienteDTO crear(ClienteCreateDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.nombre());
        cliente.setDni(dto.dni());
        cliente.setCelular(dto.celular());

        Cliente clienteCreado = clienteRepository.save(cliente);

        return new ClienteDTO(
                clienteCreado.getId(),
                clienteCreado.getNombre(),
                clienteCreado.getDni(),
                clienteCreado.getCelular(),
                clienteCreado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public ClienteDTO editar(Long id, ClienteUpdateDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el cliente con id: " + id));

        cliente.setNombre(dto.nombre());

        Cliente clienteActualizado = clienteRepository.save(cliente);

        return new ClienteDTO(
                clienteActualizado.getId(),
                clienteActualizado.getNombre(),
                clienteActualizado.getDni(),
                clienteActualizado.getCelular(),
                clienteActualizado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public void deshabilitarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el cliente con id: " + id));

        cliente.setEstado(Estado.INACTIVO);

        clienteRepository.save(cliente);
    }
}
