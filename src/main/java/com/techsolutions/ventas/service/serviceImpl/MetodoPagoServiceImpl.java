package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.MetodoPagoCreateDTO;
import com.techsolutions.ventas.dto.MetodoPagoDTO;
import com.techsolutions.ventas.dto.MetodoPagoUpdateDTO;
import com.techsolutions.ventas.enums.Estado;
import com.techsolutions.ventas.model.MetodoPago;
import com.techsolutions.ventas.repository.MetodoPagoRepository;
import com.techsolutions.ventas.service.MetodoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl implements MetodoPagoService {
    private final MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPagoDTO> listarTodos() {
        List<MetodoPago> metodosPago = metodoPagoRepository.findAll();

        return metodosPago.stream()
                .map(mp -> new MetodoPagoDTO(
                        mp.getId(),
                        mp.getNombre(),
                        mp.getEstado(),
                        mp.getFecha_creacion()
                ))
                .toList();
    }

    @Override
    public MetodoPagoDTO obtenerPorId(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el metodo de pago con id: " + id));

        return new MetodoPagoDTO(
                metodoPago.getId(),
                metodoPago.getNombre(),
                metodoPago.getEstado(),
                metodoPago.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public MetodoPagoDTO crear(MetodoPagoCreateDTO dto) {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setNombre(dto.nombre());

        MetodoPago metodoPagoGuardado = metodoPagoRepository.save(metodoPago);

        return new MetodoPagoDTO(
                metodoPagoGuardado.getId(),
                metodoPagoGuardado.getNombre(),
                metodoPagoGuardado.getEstado(),
                metodoPagoGuardado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public MetodoPagoDTO editar(Long id, MetodoPagoUpdateDTO dto) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el metodo de pago con id: " + id));

        metodoPago.setNombre(dto.nombre());
        metodoPago.setEstado(dto.estado());

        MetodoPago metodoPagoActualizado = metodoPagoRepository.save(metodoPago);

        return new MetodoPagoDTO(
                metodoPagoActualizado.getId(),
                metodoPagoActualizado.getNombre(),
                metodoPagoActualizado.getEstado(),
                metodoPagoActualizado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public void deshabilitarPorId(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el metodo de pago con id: " + id));

        metodoPago.setEstado(Estado.INACTIVO);

        metodoPagoRepository.save(metodoPago);
    }
}
