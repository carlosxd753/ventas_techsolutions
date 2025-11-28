INSERT INTO producto (nombre, precio_venta, stock, precio_compra, stock_minimo, estado, imagen_url, fecha_creacion, fecha_actualizacion) VALUES
('Laptop Lenovo IdeaPad 5', 2800.00, 12, 2300.00, 5, 'ACTIVO', 'https://i.imgur.com/6E5qONu.png', NOW(), NOW()),
('Mouse Logitech G502', 230.00, 25, 160.00, 8, 'ACTIVO', 'https://i.imgur.com/DXfnHso.png', NOW(), NOW()),
('Teclado Mecánico Redragon Kumara', 190.00, 30, 120.00, 10, 'ACTIVO', 'https://i.imgur.com/pfxJYbh.png', NOW(), NOW()),
('Monitor Samsung 27 Curvo', 950.00, 7, 750.00, 3, 'ACTIVO', 'https://i.imgur.com/hu1QeYU.png', NOW(), NOW()),
('Auriculares HyperX Cloud II', 420.00, 18, 330.00, 6, 'ACTIVO', 'https://i.imgur.com/WYdMSIa.png', NOW(), NOW()),
('Silla Gamer Cougar Armor', 1190.00, 5, 900.00, 2, 'ACTIVO', 'https://i.imgur.com/8aTx2a0.png', NOW(), NOW()),
('Tarjeta Gráfica RTX 4060', 2400.00, 6, 2000.00, 3, 'ACTIVO', 'https://i.imgur.com/O3UJvwe.png', NOW(), NOW()),
('Procesador AMD Ryzen 5 5600X', 980.00, 11, 820.00, 4, 'ACTIVO', 'https://i.imgur.com/G20TsnM.png', NOW(), NOW()),
('Placa Madre MSI B550 Tomahawk', 850.00, 9, 680.00, 3, 'ACTIVO', 'https://i.imgur.com/6juS14v.png', NOW(), NOW()),
('Memoria RAM Corsair 16GB 3200MHz', 310.00, 22, 240.00, 7, 'ACTIVO', 'https://i.imgur.com/aXINe0Q.png', NOW(), NOW()),
('SSD NVMe Samsung 980 Pro 1TB', 520.00, 17, 380.00, 6, 'ACTIVO', 'https://i.imgur.com/aBuqMKH.png', NOW(), NOW()),
('Fuente Corsair 750W Gold', 450.00, 10, 350.00, 4, 'ACTIVO', 'https://i.imgur.com/EuPSrws.png', NOW(), NOW()),
('Case Gamer NZXT H510', 430.00, 8, 340.00, 3, 'ACTIVO', 'https://i.imgur.com/CsIQhBt.png', NOW(), NOW()),
('Webcam Logitech C920', 260.00, 14, 190.00, 5, 'ACTIVO', 'https://i.imgur.com/tAo2FSX.png', NOW(), NOW()),
('Microfono Blue Yeti', 560.00, 9, 420.00, 3, 'ACTIVO', 'https://i.imgur.com/xaZ3ylw.png', NOW(), NOW()),
('Impresora Epson EcoTank L3250', 980.00, 6, 780.00, 2, 'ACTIVO', 'https://i.imgur.com/UGtNsVR.png', NOW(), NOW()),
('Tablet Samsung Galaxy Tab A8', 750.00, 10, 620.00, 4, 'ACTIVO', 'https://i.imgur.com/Q2iMDgZ.png', NOW(), NOW()),
('Smartwatch Xiaomi Watch S1', 520.00, 15, 380.00, 5, 'ACTIVO', 'https://i.imgur.com/QZlKaCv.png', NOW(), NOW()),
('Disco Duro Externo WD 2TB', 340.00, 20, 260.00, 7, 'ACTIVO', 'https://i.imgur.com/k61RjDB.png', NOW(), NOW()),
('Router TP-Link Archer AX5400', 680.00, 9, 520.00, 3, 'ACTIVO', 'https://i.imgur.com/QXlpWiw.png', NOW(), NOW());

INSERT INTO rol (nombre, estado, fecha_creacion, fecha_actualizacion) VALUES
('ADMINISTRADOR', 'ACTIVO', NOW(), NOW()),
('GERENTE', 'ACTIVO', NOW(), NOW()),
('CONTADOR', 'ACTIVO', NOW(), NOW()),
('COMPRAS', 'ACTIVO', NOW(), NOW()),
('VENTAS', 'ACTIVO', NOW(), NOW());

INSERT INTO cliente (nombre, celular, dni, estado, fecha_creacion, fecha_actualizacion) VALUES
('Pedro', '987123456', '12345670', 'ACTIVO', NOW(), NOW()),
('Carlos', '987123455', '12345671', 'ACTIVO', NOW(), NOW()),
('Jorge', '987123454', '12345672', 'ACTIVO', NOW(), NOW()),
('Ricardo', '987123453', '12345673', 'ACTIVO', NOW(), NOW()),
('Armando', '987123452', '12345674', 'ACTIVO', NOW(), NOW());

INSERT INTO metodo_pago (nombre, estado, fecha_creacion, fecha_actualizacion) VALUES
('Stripe', 'ACTIVO', NOW(), NOW()),
('Paypal', 'ACTIVO', NOW(), NOW());

INSERT INTO usuario (correo, password, estado, id_rol, fecha_creacion, fecha_actualizacion) VALUES
('administrador@techsolutions.com', '123456', 'ACTIVO', 1, NOW(), NOW()),
('gerente@techsolutions.com', '123456', 'ACTIVO', 2, NOW(), NOW()),
('contador@techsolutions.com', '123456', 'ACTIVO', 3, NOW(), NOW()),
('compras@techsolutions.com', '123456', 'ACTIVO', 4, NOW(), NOW()),
('ventas@techsolutions.com', '123456', 'ACTIVO', 5, NOW(), NOW());

INSERT INTO pedido (id_cliente, id_metodo_pago, fecha_creacion, fecha_actualizacion) VALUES
(1, 1, NOW(), NOW()),
(1, 2, NOW(), NOW());

INSERT INTO detalle_pedido (id_pedido, id_producto, sub_total, cantidad, fecha_creacion, fecha_actualizacion) VALUES
(1, 1, 2800.00, 1, NOW(), NOW()),
(1, 2, 460.00, 2, NOW(), NOW()),
(2, 3, 570.00, 3, NOW(), NOW());