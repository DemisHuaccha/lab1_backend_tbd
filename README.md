# lab1_backend_tbd

Backend desarrollado con Spring Boot para la gestión de inventario multi-tienda.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- **Java JDK 21** 
- **Maven 3.6+** 
- **PostgreSQL 12+** 
- **Git** (para clonar el repositorio)

### Verificar Instalación

```bash
java -version
mvn -version
psql --version
```

## Clonación del Repositorio

1. Clona el repositorio en tu máquina local:

```bash
git clone https://github.com/DemisHuaccha/lab1_backend_tbd.git
cd lab1_backend_tbd
```

## Configuración

### 1. Configuración de la Base de Datos

Asegúrate de que PostgreSQL esté en ejecución y crea una base de datos para la aplicación:

```bash
# Conéctate a PostgreSQL
psql -U postgres

# Crea la base de datos
CREATE DATABASE lab1_tbd;

# Salir de psql
\q
```

### 2. Variables de Entorno

La aplicación requiere las siguientes variables de entorno. Crea un archivo `.env` en la raíz del proyecto o configura las variables de entorno en tu sistema:

**Variables requeridas:**

- `DB_URL`: URL de conexión a la base de datos PostgreSQL
  - Formato: `jdbc:postgresql://localhost:5432/lab1_tbd`
  
- `DB_USER`: Usuario de la base de datos
  - Ejemplo: `postgres`

- `DB_PASSWORD`: Contraseña del usuario de la base de datos
  - Ejemplo: `tu_contraseña`

- `SECRET_KEY`: Clave secreta para la generación de tokens JWT
  - Ejemplo: `tu_clave_secreta_muy_segura_aqui`

### Configurar Variables de Entorno

#### Windows (PowerShell):

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/lab1_tbd"
$env:DB_USER="postgres"
$env:DB_PASSWORD="tu_contraseña"
$env:SECRET_KEY="tu_clave_secreta_muy_segura_aqui"
```

#### Windows (CMD):

```cmd
set DB_URL=jdbc:postgresql://localhost:5432/lab1_tbd
set DB_USER=postgres
set DB_PASSWORD=tu_contraseña
set SECRET_KEY=tu_clave_secreta_muy_segura_aqui
```

#### Linux/macOS:

```bash
export DB_URL="jdbc:postgresql://localhost:5432/lab1_tbd"
export DB_USER="postgres"
export DB_PASSWORD="tu_contraseña"
export SECRET_KEY="tu_clave_secreta_muy_segura_aqui"
```

**Nota:** Para hacer permanentes estas variables en Linux/macOS, puedes agregarlas a tu archivo `~/.bashrc` o `~/.zshrc`.

### 3. Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
lab1_backend_tbd/
├── lab1/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/          # Código fuente Java
│   │   │   └── resources/
│   │   │       ├── SqlResources/  # Scripts SQL de inicialización
│   │   │       └── application.properties  # Configuración de la aplicación
│   │   └── test/              # Pruebas unitarias
│   └── pom.xml                # Configuración de Maven
└── README.md
```

## Instalación y Compilación

1. Navega a la carpeta `lab1`:

```bash
cd lab1
```

2. Compila el proyecto usando Maven:

```bash
mvn clean install
```

Este comando:
- Limpia compilaciones anteriores
- Descarga todas las dependencias necesarias
- Compila el proyecto
- Ejecuta las pruebas

## Ejecución

### Opción 1: Ejecutar con Maven

Desde la carpeta `lab1`, ejecuta:

```bash
mvn spring-boot:run
```

### Opción 2: Ejecutar el JAR generado

Después de compilar, puedes ejecutar el JAR directamente:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Verificar que la Aplicación está Ejecutándose

Una vez iniciada, la aplicación estará disponible en:

- **URL Base:** `http://localhost:8020`
- **Puerto:** `8020` (configurado en `application.properties`)

Puedes verificar que la aplicación está corriendo accediendo a:

```bash
# Linux/macOS
curl http://localhost:8020

# Windows (PowerShell)
Invoke-WebRequest -Uri http://localhost:8020
```

### Inicialización Automática de la Base de Datos

La aplicación incluye un componente `StartUpQuery` que se ejecuta automáticamente al iniciar. Este componente:

1. Crea todas las tablas necesarias
2. Crea triggers, procedimientos almacenados y vistas materializadas
3. Opcionalmente, puede poblar la base de datos con datos de prueba (si está configurado)

Los scripts SQL se encuentran en `src/main/resources/SqlResources/` y se ejecutan en el siguiente orden:

1. `productsTable.sql`
2. `storesTable.sql`
3. `usersTable.sql`
4. `inventorysTable.sql`
5. `transactionsTable.sql`
6. `suppliersTable.sql`
7. `supplier_productTable.sql`
8. `resumen_stock_tienda.sql` (vista materializada)
9. `index_resumen_stock_tienda.sql`
10. `consulta7.sql` (trigger)
11. `transfer_inventory.sql` (procedimiento almacenado)

## Estructura de la API

### Endpoints Principales

La aplicación expone una API REST. Los endpoints principales incluyen:

- **Productos:** `/api/products`
- **Tiendas:** `/api/stores`
- **Usuarios:** `/api/users`
- **Inventario:** `/api/inventory`
- **Transacciones:** `/api/transactions`
- **Proveedores:** `/api/suppliers`

### Autenticación

La aplicación utiliza JWT (JSON Web Tokens) para la autenticación. Asegúrate de incluir el token en las peticiones que lo requieran:

```
Authorization: Bearer <tu_token_jwt>
```

## Solución de Problemas

### Error de Conexión a la Base de Datos

- Verifica que PostgreSQL esté en ejecución
- Verifica que las credenciales en las variables de entorno sean correctas
- Verifica que la base de datos `lab1_tbd` exista

### Error de Puerto en Uso

Si el puerto 8020 está ocupado, puedes cambiarlo en `src/main/resources/application.properties`:

```properties
server.port=8021
```

### Error de Variables de Entorno

Asegúrate de que todas las variables de entorno requeridas estén configuradas antes de ejecutar la aplicación.

### Logs

Los logs de la aplicación se muestran en la consola. Para más detalles, revisa los mensajes de error que aparecen al iniciar la aplicación.

## Documentación Adicional

Para más información sobre la estructura de la base de datos, consulta el archivo [DOCUMENTACION_DB.md](DOCUMENTACION_DB.md).

## Tecnologías Utilizadas

- **Spring Boot 3.5.6**
- **Java 21**
- **PostgreSQL**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Spring JDBC**
- **Maven**

## Desarrollo

### Agregar Nuevas Dependencias

Edita el archivo `pom.xml` y agrega las dependencias necesarias. Luego ejecuta:

```bash
mvn clean install
```

### Estructura de Paquetes

```
com.example.demo
├── config/          # Configuraciones (StartUpQuery, Security, etc.)
├── controllers/     # Controladores REST
├── services/        # Lógica de negocio
├── repositories/    # Acceso a datos
├── entities/        # Entidades del dominio
└── Dtos/            # Objetos de transferencia de datos
```

## Licencia

Este proyecto es parte de un laboratorio académico.

