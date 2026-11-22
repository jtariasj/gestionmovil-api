CREATE DATABASE IF NOT EXISTS gestionmovil_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE gestionmovil_db;

-- 1. Tabla USUARIO
CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

INSERT INTO usuario (nombre, correo, contrasena, rol) VALUES
('Supervisor Uno', 'supervisor@test.com', '1234', 'SUPERVISOR'),
('Ejecutivo Uno', 'ejecutivo1@test.com', '1234', 'EJECUTIVO'),
('Ejecutivo Dos', 'ejecutivo2@test.com', '1234', 'EJECUTIVO'),
('Ejecutivo Tres', 'ejecutivo3@test.com', '1234', 'EJECUTIVO'),
('Supervisora Norte', 'supervisora2@test.com', '1234', 'SUPERVISOR');

-- 2. Tabla ORGANIZACION
CREATE TABLE IF NOT EXISTS organizacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(255) NOT NULL,
    rut VARCHAR(50) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

INSERT INTO organizacion (nombre_empresa, rut, direccion) VALUES
('Minera Escondida Norte S.A.', '76.123.456-7', 'Av. Apoquindo 4500, Las Condes'),
('Constructora Andes Ltda.', '77.234.567-8', 'Av. Providencia 1234, Providencia'),
('Tecnología Austral SpA', '78.345.678-9', 'Calle Libertad 890, Viña del Mar'),
('Agroindustria del Maule S.A.', '79.456.789-0', 'Ruta 5 Sur Km 255, Talca'),
('Logística Pacífico Sur Ltda.', '76.987.654-3', 'Av. Colón 3100, Talcahuano');

-- 3. Tabla CONTACTO
CREATE TABLE IF NOT EXISTS contacto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    organizacion_id INT NOT NULL
);

INSERT INTO contacto (nombre, cargo, telefono, correo, organizacion_id) VALUES
('Camila Fuentes', 'Jefa de Marketing', '+56987654321', 'camila.fuentes@gmail.com', 1),
('Rodrigo Valdés', 'Gerente Comercial', '+56976543210', 'rodrigo.valdes@test.com', 3),
('Valentina Rojas', 'Coordinadora de Eventos', '+56965432109', 'valentina.rojas@gmail.com', 2),
('Sebastián Morales', 'Subgerente de Operaciones', '+56954321098', 'sebastian.morales@test.com', 5),
('Fernanda Castro', 'Encargada de Adquisiciones', '+56943210987', 'fernanda.castro@gmail.com', 4);

-- 4. Tabla OPORTUNIDAD
CREATE TABLE IF NOT EXISTS oportunidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    fuente_informacion VARCHAR(255) NOT NULL,
    fecha_deteccion BIGINT NOT NULL,
    responsable VARCHAR(255) NOT NULL,
    prioridad VARCHAR(50) NOT NULL,
    potencial_comercial VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_actualizacion BIGINT NOT NULL,
    observaciones TEXT,
    foto_path VARCHAR(500) NULL
);

INSERT INTO oportunidad (
    nombre, tipo, descripcion, fuente_informacion, fecha_deteccion,
    responsable, prioridad, potencial_comercial, estado,
    fecha_actualizacion, observaciones, foto_path
) VALUES
      ('Expo Minería Antofagasta 2026', 'FERIA_EMPRESARIAL', 'Stand corporativo para exhibición de maquinaria industrial', 'Portal Web Sectorial', 1794000000000, 'Ejecutivo Uno', 'ALTA', 'ALTO', 'EVENTO_IDENTIFICADO', 1794000000000, 'Solicitar cotización de espacio esquina', NULL),
      ('Feria Construcción Sustentable', 'EVENTO_CORPORATIVO', 'Activación de marca y demostración en vivo de materiales', 'Cámara Chilena de la Construcción', 1794100000000, 'Ejecutivo Dos', 'MEDIA', 'MEDIO', 'EVENTO_IDENTIFICADO', 1794100000000, 'Incluir material audiovisual', NULL),
      ('Encuentro Innovación Tecnológica', 'FERIA_INSTITUCIONAL', 'Pabellón de soluciones digitales para empresas', 'LinkedIn Corporativo', 1794200000000, 'Ejecutivo Tres', 'ALTA', 'ALTO', 'EVENTO_IDENTIFICADO', 1794200000000, 'Alta afluencia de gerentes TI', NULL),
      ('Feria Agroindustrial del Sur', 'ACTIVACION_COMERCIAL', 'Muestra de equipamiento agrícola y riego tecnificado', 'Invitación directa', 1794300000000, 'Ejecutivo Uno', 'MEDIA', 'ALTO', 'EVENTO_IDENTIFICADO', 1794300000000, 'Coordinar traslado de equipos', NULL),
      ('Expo Logística y Comercio Exterior', 'FERIA_EMPRESARIAL', 'Rueda de negocios y stand informativo portuario', 'Boletín Industrial', 1794400000000, 'Ejecutivo Dos', 'BAJA', 'BAJO', 'EVENTO_IDENTIFICADO', 1794400000000, 'Evaluar participación compartida', NULL);

-- 5. Tabla SEGUIMIENTO
CREATE TABLE IF NOT EXISTS seguimiento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha BIGINT NOT NULL,
    descripcion TEXT NOT NULL,
    tipo_gestion VARCHAR(100) NOT NULL,
    oportunidad_id INT NOT NULL
);

INSERT INTO seguimiento (fecha, descripcion, tipo_gestion, oportunidad_id) VALUES
(1794500000000, 'Llamada inicial con encargado de pabellón para consultar tarifas', 'Llamada', 1),
(1794550000000, 'Envío de brochure corporativo y propuesta de auspicio', 'Correo', 3),
(1794600000000, 'Reunión presencial para revisar plano de ubicación del stand', 'Reunión', 2),
(1794650000000, 'Confirmación de dimensiones eléctricas requeridas en el recinto', 'Correo', 1),
(1794700000000, 'Seguimiento telefónico sobre disponibilidad de acreditaciones', 'Llamada', 4);