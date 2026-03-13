# 📒 Agenda Personal

Proyecto académico desarrollado en Java para la **Universidad del Quindío** como parte del curso de Programación Orientada a Objetos (POO). Simula una agenda digital que permite gestionar contactos, grupos y reuniones, incluyendo operaciones de ordenamiento, estadísticas y organización por fechas.

---

## 📁 Estructura del proyecto

```
src/
├── main/java/co/edu/uniquindio/poo/
│   ├── application/
│   │   └── App.java           # Punto de entrada de la aplicación
│   └── model/
│       ├── Agenda.java        # Gestión central de contactos, grupos y reuniones
│       ├── Contacto.java      # Entidad contacto
│       ├── Grupo.java         # Agrupación de contactos por categoría
│       ├── Reunion.java       # Entidad reunión con lista de asistentes
│       ├── Categoria.java     # Enum con categorías de grupo
└── test/java/co/edu/uniquindio/poo/
    └── AppTest.java           # Pruebas unitarias
```

---

## 🧩 Clases principales

### `Categoria` (enum)
Clasifica los grupos de contactos:
`OFICINA` · `FIESTA` · `AMIGOS` · `FAMILIA`

### `Contacto`
Representa una persona en la agenda.

**Atributos:** `nombre`, `alias`, `direccion`, `telefono`, `email`, `edad`

- La edad se asigna **aleatoriamente** entre 15 y 60 años al crear el contacto.
- Dos contactos son iguales si coinciden en `nombre` y `telefono`.

### `Grupo`
Agrupa hasta **5 contactos** bajo una categoría. Evita duplicados y controla el cupo disponible.

**Métodos principales:**
- `agregar_contacto(Contacto)` — Agrega un contacto si hay cupo y no está duplicado.
- `eliminar_contacto(Contacto)` — Elimina un contacto del grupo.
- `contarcontactos()` — Retorna la cantidad de contactos actuales.

### `Reunion`
Representa un evento con descripción, fecha, hora y lista de asistentes de capacidad variable.

**Métodos principales:**
- `agregar_contacto(Contacto)` — Agrega un asistente si hay cupo.
- `eliminar_contacto(Contacto)` — Elimina un asistente.

### `Agenda`
Clase central que gestiona arreglos de contactos, grupos y reuniones con tamaño fijo definido al instanciar.

**Operaciones sobre contactos:**
| Método | Descripción |
|---|---|
| `crearcontacto(Contacto)` | Agrega si no existe y hay cupo |
| `EliminarContacto(Contacto)` | Elimina por nombre y teléfono |
| `ActualizarContacto(...)` | Actualiza todos los datos |
| `buscarContacto(Contacto)` | Búsqueda por nombre y teléfono |
| `OrdenamientoBurbujaEdadContactos()` | Ordena contactos por edad (burbuja) |
| `PromedioEdadContactos()` | Calcula el promedio de edades |
| `desviacionedades()` | Calcula la desviación estándar de edades |
| `ContactosMenoresA18()` | Lista contactos menores de 18 años |
| `obteneredadmasrepetida()` | Retorna la edad más frecuente |
| `borrarcontacto3vocales()` | Elimina contactos con 3+ vocales en el nombre |
| `imprimirnombresalreves()` | Imprime cada nombre de atrás hacia adelante |
| `ImprimirContactosPosImpares()` | Imprime contactos en posiciones impares |

**Operaciones sobre grupos:**
- `creargrupo`, `EliminarGrupo`, `Actualizargrupo`, `buscargrupo`
- `GrupoConMasContactos()` — Retorna el grupo con más contactos registrados.
- `agregarcontactonombre(String, Contacto)` — Agrega un contacto a un grupo por nombre del grupo.

**Operaciones sobre reuniones:**
- `crearreunion`, `Eliminarreunion`, `Actualizarreunion`, `buscarreunion`
- `matrizreuniones()` — Organiza las reuniones en una matriz 3×N según el mes (noviembre, diciembre o enero).

---

## ▶️ Ejemplo de ejecución

La clase `App` demuestra el flujo principal:

1. Se crean 3 contactos y se registran en la agenda.
2. Se muestra la lista de contactos, luego se ordenan por edad y se vuelven a mostrar.
3. Se imprime cada nombre en orden inverso de caracteres.
4. Se crea un grupo *"Los reales"* de categoría `AMIGOS` con 2 contactos.
5. Se crean 2 reuniones con fechas en noviembre de 2022 y se organizan en la matriz mensual.
6. Se solicita al usuario una frase y se muestra carácter por carácter.

---

## 🛠️ Tecnologías

- **Java** (SE 8+)
- **Maven** (gestión del proyecto)
- **JUnit 5** (pruebas unitarias)
- **Swing / JOptionPane** (interfaz de usuario)

---

## 🚀 Cómo ejecutar

```bash
# Clonar el repositorio
git clone <url-del-repositorio>

# Compilar con Maven
mvn compile

# Ejecutar
mvn exec:java -Dexec.mainClass="co.edu.uniquindio.poo.application.App"
```

---

## 📄 Licencia

GNU/GPL V3.0 — [Ver licencia](https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
