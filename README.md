# Product Microservice

Este microservicio se encarga de la administración de los productos de crédito de un banco, gestionando todos los productos ofrecidos. Está registrado en un API Gateway y puede ser consumido desde la siguiente dirección: [http://4.152.240.150:8080/](http://4.152.240.150:8080/).

## Descripción del Proyecto

El microservicio de productos proporciona diversas operaciones para la gestión de productos de crédito, incluyendo la creación, consulta y gestión de los mismos. A continuación se detallan los endpoints disponibles y su funcionalidad.

## Endpoints

### Crear un Producto
- **Descripción**: Añadir un nuevo producto a la base de datos.
- **Método**: `POST`
- **Ruta**: `http://4.152.240.150:8080/products`
- **Código de Respuesta**: 201 - Producto creado exitosamente.

### Obtener Lista de Productos
- **Descripción**: Obtener una lista de todos los productos.
- **Método**: `GET`
- **Ruta**: `http://4.152.240.150:8080/products`
- **Código de Respuesta**: 200 - Operación exitosa, 404 - Productos no encontrados.

### Obtener un Producto por ID
- **Descripción**: Obtener la información de un producto específico por su ID.
- **Método**: `GET`
- **Ruta**: `http://4.152.240.150:8080/products/{id}`
- **Códigos de Respuesta**: 200 - Operación exitosa, 404 - Producto no encontrado.

## Integración y Despliegue

Este microservicio está integrado dentro de un clúster de AKS (Azure Kubernetes Service) con integración continua. Cada commit se almacena en un registro y el despliegue se realiza de manera automática, garantizando que siempre esté disponible la versión más reciente y funcional del servicio.

## Información Adicional

Para ver más información de las peticiones, tanto body, request y response, revisar el contrato API en el recurso del proyecto.
