# Proyecto: practicaUno (Android Nativo - Kotlin)

## 📝 Descripción Detallada del Proyecto

**practicaUno** es una aplicación educativa desarrollada para Android de forma nativa utilizando Kotlin. El propósito principal de este proyecto es servir como un catálogo interactivo que demuestra el uso y la funcionalidad de los componentes de interfaz de usuario (UI) más comunes en el ecosistema de Android Jetpack.

La aplicación está estructurada en dos flujos principales, cada uno manejado por una `Activity` distinta para separar los componentes básicos de los más avanzados:

1.  **`MainActivity`**: Es la pantalla de inicio. Contiene una barra de navegación inferior (`BottomNavigationView`) que permite explorar tres fragments con componentes fundamentales:
    * **Textos**: Demuestra el uso de `TextInputLayout` y `TextInputEditText`.
    * **Botones**: Muestra la implementación de `Button` y `ImageButton`.
    * **Selección**: Presenta `CheckBox`, `RadioButton` y `SwitchMaterial`.
    * Además, incluye un botón para navegar hacia la sección de componentes avanzados.

2.  **`SecondActivity`**: Esta pantalla se enfoca en componentes que manejan colecciones de datos o muestran información de estado. También utiliza una `BottomNavigationView` para organizar sus dos fragments:
    * **Listas**: Implementa un `RecyclerView` para mostrar una lista de datos de manera eficiente.
    * **Info**: Contiene `ImageView` y `ProgressBar` para la visualización de información.

El proyecto utiliza **View Binding** para interactuar con las vistas de forma segura y el **Componente de Navegación de Jetpack** para gestionar el flujo entre fragments dentro de cada `Activity`.

---

## 🚀 Instrucciones de Ejecución y Pruebas

Sigue estos pasos para compilar y ejecutar la aplicación en tu entorno local.

### **Pre-requisitos**
* **Android Studio**: Versión Hedgehog (2023.1.1) o superior.
* **JDK**: Versión 17 o superior.
* Un emulador de Android (API 21 o superior) o un dispositivo físico.

### **Pasos para la Ejecución**
1.  **Clonar el Repositorio**:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    ```
2.  **Abrir en Android Studio**:
    * Abre Android Studio.
    * Selecciona `File > Open` y navega hasta la carpeta del proyecto `practicaUno`.
3.  **Sincronizar Gradle**: Espera a que Android Studio termine de sincronizar y construir el proyecto. Esto puede tardar unos minutos la primera vez.
4.  **Seleccionar Dispositivo**: Elige un emulador disponible o conecta un dispositivo físico con la depuración USB habilitada.
5.  **Ejecutar la App**: Haz clic en el botón **Run 'app'** (icono de play ▶️) en la barra de herramientas superior.

---

## 📸 Capturas de Pantalla

A continuación, se muestran algunas capturas que demuestran las funcionalidades clave de la aplicación.

| Pantalla Principal (MainActivity) | Demostración de Selección | Pantalla Avanzada (SecondActivity) |
| :--------------------------------: | :---------------------------: | :----------------------------------: |
| ![Pantalla principal con 3 tabs y botón de navegación](ruta/a/screenshot1.png) | ![Fragment de selección interactivo](ruta/a/screenshot2.png) | ![Pantalla de listas y barra de regreso](ruta/a/screenshot3.png) |

*(Nota: Debes reemplazar `ruta/a/screenshot.png` con la ubicación real de tus capturas de pantalla dentro del proyecto para que se visualicen).*

---

## 🧐 Dificultades y Soluciones

Durante el desarrollo, surgieron algunos desafíos técnicos comunes en Android que requirieron soluciones específicas.

### **Dificultad 1: Gestión del Ciclo de Vida de los Fragments y View Binding**
* **Problema**: La aplicación crasheaba con un `NullPointerException` al regresar a un fragment después de haber estado en segundo plano. Esto ocurría porque la vista del fragment (`view`) puede ser destruida mientras el fragment en sí (`Fragment`) sigue en memoria. Al intentar acceder a un elemento de la vista a través del `binding`, este ya era nulo.
* **Solución**: Implementé el patrón de `binding` nulable. La variable `_binding` es privada y nulable, mientras que `binding` es una propiedad pública no nulable que solo se usa entre `onCreateView` y `onDestroyView`. En `onDestroyView`, se establece explícitamente `_binding = null`, lo que libera la referencia a la vista y previene fugas de memoria y crasheos.

### **Dificultad 2: Configuración de la Navegación entre dos Activities con Navigation Component**
* **Problema**: Asegurar que la flecha de "Atrás" (Up Button) en la `SecondActivity` regresara correctamente a la `MainActivity` y no simplemente cerrara la app.
* **Solución**: La clave fue configurar correctamente el `AndroidManifest.xml`. Añadí el atributo `android:parentActivityName=".MainActivity"` a la declaración de la `SecondActivity`. Luego, en `SecondActivity.kt`, sobrescribí el método `onSupportNavigateUp()` para que invocara `onBackPressedDispatcher.onBackPressed()`, asegurando el comportamiento de navegación esperado.

---

## 💡 Hallazgos

* **Modularidad con Fragments**: La división de la UI en Fragments demostró ser extremadamente efectiva para crear componentes modulares y reutilizables. Cada fragment gestiona su propia lógica y layout, manteniendo el código de las `Activities` limpio y enfocado solo en la orquestación.
* **Separación de Flujos con Activities**: Utilizar dos `Activities` fue una decisión acertada para separar claramente los flujos de trabajo (componentes básicos vs. avanzados). Esto simplifica el grafo de navegación de cada `Activity` y hace que la aplicación sea más escalable.
* **Poder del Componente de Navegación**: El Navigation Component de Jetpack abstrae la complejidad de las transacciones de fragments, la gestión del back stack y el paso de argumentos, resultando en un código de navegación mucho más declarativo y fácil de mantener.
