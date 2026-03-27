# Sistema de Pedidos de Comida
## Autores
### Andres Mauricio Quintero Rios
### Oscar Rene  Peñaloza Ardila

## Descripción del Proyecto

Sistema de gestión de pedidos de comida que permite crear clientes, registrar pedidos con múltiples productos y visualizar el historial completo de todos los pedidos realizados.

## Estructura del Proyecto

```
src/
├── App.java                           # Clase principal con menú interactivo
├── modelo/
│   ├── Usuario.java                   # Clase base para usuarios
│   ├── Cliente.java                   # Subclase que hereda de Usuario
│   ├── Producto.java                  # Clase para representar productos
│   └── Pedido.java                    # Clase para gestionar pedidos
├── factoryMethod/
│   └── ProductoFactory.java           # Factory Method para crear productos
└── singleton/
    └── SistemaPedidos.java            # Singleton para gestionar el sistema
```

## 1. Clases, Subclases y Relaciones

### Clases Principales (3+)

#### 1.1 Usuario (Clase Base)
- **Propósito**: Clase base que define atributos comunes para todos los usuarios
- **Atributos**: nombre, email
- **Métodos**: getters y setters

#### 1.2 Producto (Clase Principal)
- **Propósito**: Representa un producto en el sistema
- **Atributos**: nombre, precio
- **Métodos**: getters y setters

#### 1.3 Pedido (Clase Principal)
- **Propósito**: Gestiona un pedido completo con cliente y productos
- **Atributos**: cliente, lista de productos
- **Métodos**: calcularTotal(), getCliente(), getProductos()

### Subclase (Herencia)

#### 1.4 Cliente (Subclase de Usuario)
- **Herencia**: Extiende la clase Usuario
- **Atributos adicionales**: idCliente
- **Métodos**: getIdCliente(), setIdCliente()

### Relaciones entre Clases

#### 1.5 Asociación: Pedido ↔ Cliente
- **Tipo**: Asociación bidireccional
- **Descripción**: Un pedido está asociado a un cliente
- **Implementación**: Pedido contiene un objeto Cliente

#### 1.6 Composición: Pedido → Producto
- **Tipo**: Composición (Pedido contiene Productos)
- **Descripción**: Un pedido está compuesto por múltiples productos
- **Implementación**: Pedido contiene una lista de objetos Producto
- **Ciclo de vida**: Los productos no existen independientemente del pedido

## 2. Patrones de Diseño

### 2.1 Singleton (SistemaPedidos)
- **Propósito**: Garantizar una única instancia del gestor del sistema
- **Implementación**:
  ```java
  public class SistemaPedidos {
      private static SistemaPedidos instancia;
      private List<Pedido> pedidos;
      
      private SistemaPedidos(){
          this.pedidos = new ArrayList<>();
      }
      
      public static SistemaPedidos getInstancia() {
          if (instancia == null) {
              instancia = new SistemaPedidos();
          }
          return instancia;
      }
  }
  ```
- **Ventajas**: Control centralizado de todos los pedidos, acceso global

### 2.2 Factory Method (ProductoFactory)
- **Propósito**: Crear diferentes tipos de productos de forma flexible
- **Implementación**:
  ```java
  public static Producto crearProducto(String tipoString, String nombre, double precio) {
      switch (tipoString.toLowerCase()) {
          case "bebida": return new Producto(nombre +" bebida", precio);
          case "comida": return new Producto(nombre +" comida", precio);
          case "postre": return new Producto(nombre +" postre", precio);
          default: throw new IllegalArgumentException("Tipo no reconocido");
      }
  }
  ```
- **Ventajas**: Desacoplamiento, fácil extensión para nuevos tipos

## 3. Programación Funcional

### 3.1 Uso de Streams y Lambda

#### Cálculo del total del pedido:
```java
public Double calcularTotal() {
   return productos.stream()
                   .mapToDouble(Producto::getPrecio)
                   .sum();
}
```

#### Mostrar todos los pedidos:
```java
pedido.getProductos().forEach(producto -> 
    System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio())
);
```

### 3.2 Métodos Funcionales Utilizados
- **stream()**: Convierte colección a stream para procesamiento funcional
- **mapToDouble()**: Transforma objetos Producto a valores double
- **sum()**: Opera reducción para calcular total
- **forEach()**: Itera sobre elementos con expresión lambda

## 4. Gestión de Errores y Validaciones

### 4.1 Validación de Entradas de Usuario
```java
try {
    System.out.print("ID del cliente: ");
    int idCliente = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer
} catch (Exception e) {
    System.out.println("Error: El ID debe ser un número válido");
}
```

### 4.2 Validación de Tipos de Producto
```java
try {
    Producto producto = ProductoFactory.crearProducto(tipoProducto, nombreProducto, precioProducto);
    productos.add(producto);
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### 4.3 Manejo General de Errores
```java
try {
    // Lógica principal
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Error inesperado: " + e.getMessage());
} finally {
    scanner.close();
}
```

### 4.4 Estrategias de Validación
- **Validación de tipos**: Verificar que los datos numéricos sean válidos
- **Validación de dominio**: Asegurar que los tipos de producto sean reconocidos
- **Mensajes personalizados**: Proporcionar retroalimentación clara al usuario
- **Recuperación controlada**: El programa continúa ejecutándose después de errores

## Características Adicionales

### Menú Interactivo
- Opción 1: Crear nuevo pedido
- Opción 2: Ver todos los pedidos
- Opción 3: Salir del sistema

### Gestión por Categorías
- Entrada estructurada por categorías (bebidas, comidas, postres)
- Posibilidad de agregar productos adicionales

### Persistencia en Memoria
- Todos los pedidos se almacenan en memoria durante la ejecución
- Acceso completo al historial de pedidos

## Ejecución del Programa

1. Compilar el proyecto:
```bash
javac src/**/*.java
```

2. Ejecutar la aplicación:
```bash
java App
```

3. Seguir las instrucciones del menú interactivo
