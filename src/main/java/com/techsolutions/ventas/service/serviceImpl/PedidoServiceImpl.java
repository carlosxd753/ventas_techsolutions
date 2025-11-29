package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.*;
import com.techsolutions.ventas.exceptions.EntidadNoEncontradaException;
import com.techsolutions.ventas.model.*;
import com.techsolutions.ventas.repository.*;
import com.techsolutions.ventas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final MetodoPagoRepository metodoPagoRepository;
    private final ProductoRepository productoRepository;

    @Override
    public List<PedidoDTO> listarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream()
                .map(this::convertirAPedidoDTO)
                .toList();
    }

    @Override
    public PedidoDTO obtenerPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el pedido con id: " + id));

        return convertirAPedidoDTO(pedido);
    }

    @Override
    @Transactional
    public PedidoDTO crear(PedidoCreateRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el cliente con id: " + dto.idCliente()));

        MetodoPago metodoPago = metodoPagoRepository.findById(dto.idMetodoPago())
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el metodo de pago con id: " + dto.idMetodoPago()));

        Pedido pedido = new  Pedido();
        pedido.setCliente(cliente);
        pedido.setMetodoPago(metodoPago);

        List<DetallePedido> detalles = new ArrayList<>();

        for (DetallePedidoCreateRequestDTO d : dto.detallePedido()) {
            Producto producto = productoRepository.findById(d.idProducto())
                    .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el producto con id: " + d.idProducto()));

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(d.cantidad());

            BigDecimal subTotal = producto.getPrecioVenta().multiply(BigDecimal.valueOf(d.cantidad()));
            detalle.setSubTotal(subTotal);

            detalles.add(detalle);
        }

        pedido.setDetalles(detalles);

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        return convertirAPedidoDTO(pedidoGuardado);
    }

    @Override
    @Transactional
    public PedidoDTO editar(Long id, PedidoUpdateDTO dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el pedido con id: " + id));

        pedido.getDetalles().clear();

        for (DetallePedidoDTO dpDTO : dto.detallePedido()) {
            Producto producto = productoRepository.findById(dpDTO.producto().id())
                    .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el producto con id: " + dpDTO.producto().id()));

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(dpDTO.cantidad());
            detalle.setSubTotal(dpDTO.subTotal());

            pedido.getDetalles().add(detalle);
        }

        Pedido pedidoActualizado =  pedidoRepository.save(pedido);

        return  convertirAPedidoDTO(pedidoActualizado);
    }

    @Override
    @Transactional
    public void borrarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el pedido con id: " + id));

        pedidoRepository.delete(pedido);
    }

    private PedidoDTO convertirAPedidoDTO(Pedido p) {
        return new PedidoDTO(
                p.getId(),
                new ClienteDTO(
                        p.getCliente().getId(),
                        p.getCliente().getNombre(),
                        p.getCliente().getDni(),
                        p.getCliente().getCelular(),
                        p.getCliente().getFecha_creacion()
                ),
                new MetodoPagoDTO(
                        p.getMetodoPago().getId(),
                        p.getMetodoPago().getNombre(),
                        p.getMetodoPago().getEstado(),
                        p.getMetodoPago().getFecha_creacion()
                ),
                p.getDetalles().stream()
                        .map(dp -> new DetallePedidoDTO(
                                new ProductoDTO(
                                        dp.getProducto().getId(),
                                        dp.getProducto().getNombre(),
                                        dp.getProducto().getPrecioVenta(),
                                        dp.getProducto().getStock(),
                                        dp.getProducto().getPrecioCompra(),
                                        dp.getProducto().getStockMinimo(),
                                        dp.getProducto().getImagenUrl(),
                                        dp.getProducto().getFecha_creacion()
                                ),
                                dp.getCantidad(),
                                dp.getSubTotal()
                        ))
                        .toList(),
                p.getFecha_creacion()
        );
    }
}
