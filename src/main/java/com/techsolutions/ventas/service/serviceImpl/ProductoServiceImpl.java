package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.ProductoDTO;
import com.techsolutions.ventas.dto.ProductoRequestDTO;
import com.techsolutions.ventas.enums.Estado;
import com.techsolutions.ventas.exceptions.EntidadNoEncontradaException;
import com.techsolutions.ventas.model.Producto;
import com.techsolutions.ventas.repository.ProductoRepository;
import com.techsolutions.ventas.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarTodos() {
        List<Producto> productos =  productoRepository.findAll();

        return productos.stream()
                .map(p -> new ProductoDTO(
                        p.getId(),
                        p.getNombre(),
                        p.getPrecioVenta(),
                        p.getStock(),
                        p.getPrecioCompra(),
                        p.getStockMinimo(),
                        p.getImagenUrl(),
                        p.getFecha_creacion()
                ))
                .toList();
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el producto con id: " + id));

        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecioVenta(),
                producto.getStock(),
                producto.getPrecioCompra(),
                producto.getStockMinimo(),
                producto.getImagenUrl(),
                producto.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public ProductoDTO crear(ProductoRequestDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setPrecioVenta(dto.precioVenta());
        producto.setStock(dto.stock());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setStockMinimo(dto.stockMinimo());

        Producto productoGuardado =  productoRepository.save(producto);

        return new ProductoDTO(
                productoGuardado.getId(),
                productoGuardado.getNombre(),
                productoGuardado.getPrecioVenta(),
                productoGuardado.getStock(),
                productoGuardado.getPrecioCompra(),
                productoGuardado.getStockMinimo(),
                productoGuardado.getImagenUrl(),
                productoGuardado.getFecha_creacion()
        );
    }

    @Override
    public ProductoDTO editar(Long id, ProductoRequestDTO dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el producto con id: " + id));

        producto.setNombre(dto.nombre());
        producto.setPrecioVenta(dto.precioVenta());
        producto.setStock(dto.stock());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setStockMinimo(dto.stockMinimo());

        Producto productoActualizado = productoRepository.save(producto);

        return new ProductoDTO(
                productoActualizado.getId(),
                productoActualizado.getNombre(),
                productoActualizado.getPrecioVenta(),
                productoActualizado.getStock(),
                productoActualizado.getPrecioCompra(),
                productoActualizado.getStockMinimo(),
                productoActualizado.getImagenUrl(),
                productoActualizado.getFecha_creacion()
        );
    }

    @Override
    public void deshabilitarPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el producto con id: " + id));

        producto.setEstado(Estado.INACTIVO);

        productoRepository.save(producto);
    }
}
