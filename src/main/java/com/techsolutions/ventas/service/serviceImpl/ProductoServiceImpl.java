package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.ProductoDTO;
import com.techsolutions.ventas.dto.ProductoRequestDTO;
import com.techsolutions.ventas.enums.Estado;
import com.techsolutions.ventas.exceptions.EntidadNoEncontradaException;
import com.techsolutions.ventas.model.Producto;
import com.techsolutions.ventas.repository.ProductoRepository;
import com.techsolutions.ventas.service.PrecioService;
import com.techsolutions.ventas.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final PrecioService precioService;

    @Override
    public Page<ProductoDTO> listarTodos(String busqueda, Pageable pageable) {
        Page<Producto> productos;

        if (busqueda == null || busqueda.isBlank()){
            productos = productoRepository.findAll(pageable);
        } else {
            productos = productoRepository.findByNombreContainingIgnoreCase(busqueda, pageable);
        }

        return productos.map(p -> {
            BigDecimal precioVenta = precioService.obtenerPrecio(p.getPrecioBase());
            return new ProductoDTO(
                    p.getId(),
                    p.getNombre(),
                    precioVenta,
                    p.getStock(),
                    p.getPrecioCompra(),
                    p.getStockMinimo(),
                    p.getImagenUrl(),
                    p.getFecha_creacion()
            );
        });
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontro el producto con id: " + id));

        BigDecimal precioVenta = precioService.obtenerPrecio(producto.getPrecioBase());

        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                precioVenta,
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
        producto.setPrecioBase(dto.precioVenta());
        producto.setStock(dto.stock());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setStockMinimo(dto.stockMinimo());
        producto.setImagenUrl(dto.imagenUrl());

        Producto productoGuardado =  productoRepository.save(producto);

        BigDecimal precioVenta = precioService.obtenerPrecio(producto.getPrecioBase());

        return new ProductoDTO(
                productoGuardado.getId(),
                productoGuardado.getNombre(),
                precioVenta,
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
        producto.setPrecioBase(dto.precioVenta());
        producto.setStock(dto.stock());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setStockMinimo(dto.stockMinimo());
        producto.setImagenUrl(dto.imagenUrl());

        Producto productoActualizado = productoRepository.save(producto);

        BigDecimal precioVenta = precioService.obtenerPrecio(producto.getPrecioBase());

        return new ProductoDTO(
                productoActualizado.getId(),
                productoActualizado.getNombre(),
                precioVenta,
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
