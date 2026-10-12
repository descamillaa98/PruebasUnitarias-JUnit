# Ejercicio: Cálculo de compras y descuentos

## Objetivo

Implementar reglas de negocio sencillas para una tienda en línea y verificar su comportamiento mediante pruebas unitarias con JUnit 6.

En este ejercicio combinarás métodos, condiciones y cálculos numéricos. También aprenderás a diseñar pruebas para detectar errores que podrían afectar directamente el precio que paga un cliente.

## Contexto

Estás desarrollando una parte del backend de una tienda en línea. El sistema necesita calcular el importe de una compra, determinar si puede aplicar un descuento y obtener el precio final.

Una operación incorrecta podría provocar que un cliente pague de más o de menos. Tu responsabilidad es comprobar que los cálculos funcionen correctamente antes de integrar estas funciones en el resto de la aplicación.

## Parte 1. Implementación en Java

Crea una clase llamada `PurchaseCalculator` con los siguientes métodos:

| Método | Comportamiento esperado |
|---|---|
| `calculateSubtotal(double price, int quantity)` | Devuelve el precio de un producto multiplicado por la cantidad solicitada. |
| `isValidPurchase(double price, int quantity)` | Devuelve `true` si el precio es mayor que cero y la cantidad es mayor que cero. |
| `calculateDiscount(double subtotal)` | Devuelve el 10 % del subtotal cuando este sea igual o superior a $1,000. Si es menor, devuelve cero. |
| `calculateFinalPrice(double subtotal)` | Devuelve el subtotal menos el descuento correspondiente. |

Para este ejercicio, los importes se expresan en pesos mexicanos y los valores monetarios se manejan con `double` para mantener el nivel de dificultad básico. En sistemas reales, conviene estudiar el uso de `BigDecimal` para cálculos monetarios.

### Requisitos

- Implementa los cuatro métodos.
- Reutiliza `calculateDiscount` dentro de `calculateFinalPrice`.
- No necesitas desarrollar una tienda completa ni crear una interfaz.
- No es necesario utilizar arreglos, colecciones, bases de datos ni clases adicionales.
- Para `calculateDiscount` y `calculateFinalPrice`, considera que el subtotal recibido es cero o positivo.
- No necesitas implementar redondeo monetario en este ejercicio.

## Parte 2. Pruebas unitarias con JUnit 6

Crea una clase llamada `PurchaseCalculatorTest`.

Diseña pruebas que comprueben cada método de manera independiente y que permitan identificar errores en las reglas de negocio.

### Casos que debes considerar

**Cálculo del subtotal**

- Un producto con precio de $100 y cantidad de 3.
- Un producto con cantidad de 1.
- Un producto con precio de $0.

**Validación de la compra**

- Precio y cantidad positivos.
- Precio igual a cero.
- Cantidad igual a cero.
- Precio negativo.

**Cálculo del descuento**

- Subtotal inferior a $1,000.
- Subtotal exactamente igual a $1,000.
- Subtotal superior a $1,000.

**Cálculo del precio final**

- Compra sin descuento.
- Compra con descuento.
- Compra cuyo subtotal es exactamente $1,000.

### Consideraciones

- Utiliza aserciones apropiadas para verificar los resultados numéricos y booleanos.
- Cuando compares valores `double`, utiliza una tolerancia adecuada en la aserción numérica.
- Comprueba los límites de la regla del descuento: un error al utilizar `>` en lugar de `>=` podría provocar que un cliente no recibiera el descuento que le corresponde.
- No necesitas crear una prueba para cada combinación posible de precio y cantidad, pero sí justificar la selección de los casos.

## Parte 3. Documentación con apoyo de IA

Crea un archivo llamado `DOCUMENTACION.md`.

Solicita a una herramienta de IA que te ayude a redactar un documento técnico sencillo a partir de tus métodos y pruebas.

El documento debe contener las siguientes secciones:

1. **Descripción del problema:** explica qué cálculos realiza el sistema y por qué es importante verificarlos.
2. **Reglas de negocio:** documenta cómo se calcula el subtotal, cuándo se permite una compra y cuándo se aplica el descuento.
3. **Casos de prueba:** incluye los datos de entrada, el resultado esperado, el resultado obtenido y una explicación breve del propósito de cada caso.
4. **Resultados de ejecución:** registra cuántas pruebas pasaron y cuántas fallaron, de acuerdo con la ejecución real.
5. **Errores que se pueden prevenir:** describe al menos dos errores que las pruebas permitirían detectar.
6. **Conclusión:** explica cómo las pruebas unitarias contribuyen a la confiabilidad de una aplicación de comercio electrónico.

Puedes presentar los casos de prueba en una tabla Markdown.

**Importante:** la IA puede ayudarte a redactar, pero debes verificar cada resultado con el código y la ejecución de JUnit. La documentación no sustituye las pruebas.

## Configuración del proyecto

Trabaja con IntelliJ IDEA y su sistema de compilación integrado.

- Utiliza Java 17 o superior.
- Agrega JUnit 6 al proyecto desde las opciones del IDE.
- Crea `PurchaseCalculator.java` en el código fuente y `PurchaseCalculatorTest.java` en el directorio de pruebas.
- Ejecuta todas las pruebas y revisa sus resultados.

No utilices Maven ni Gradle.

## Uso de `.gitignore`

Incluye un archivo `.gitignore` en la raíz del repositorio:

```gitignore
# Archivos de configuración local de IntelliJ IDEA
.idea/
*.iml

# Archivos compilados
out/
*.class

# Archivos del sistema operativo
.DS_Store
Thumbs.db
```

Por ejemplo, `out/` evita que Git incluya los archivos generados durante la compilación dentro de ese directorio. La regla `*.class` excluye los archivos compilados de Java.

Si IntelliJ genera archivos adicionales que no deban compartirse, puedes agregar sus rutas o patrones al archivo.

No agregues al `.gitignore` tus clases Java, las pruebas unitarias ni `DOCUMENTACION.md`.

## Entregables

- `PurchaseCalculator.java`
- `PurchaseCalculatorTest.java`
- `DOCUMENTACION.md`
- `.gitignore`

Entrega tus cambios mediante un commit en Git.

## Criterios de revisión

- Los métodos cumplen las reglas de negocio indicadas.
- Las pruebas cubren resultados habituales y casos límite.
- Se verifican correctamente los valores numéricos y booleanos.
- La documentación permite comprender qué se probó y qué resultados se obtuvieron.
- El repositorio contiene los archivos requeridos y excluye los archivos generados.

## Reflexión final

**Imagina que el cálculo del descuento funciona correctamente para una compra de $1,200, pero falla cuando la compra es exactamente de $1,000. ¿Qué prueba permitiría detectar ese error y qué consecuencias podría tener en la aplicación?**