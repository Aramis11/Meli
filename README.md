# Mercado Libre - MVVM - Clean architecture
## Challenge MELI

<img src="./images/IMG_1.png">
<img src="./images/IMG_2.png">
<img src="./images/IMG_3.png">

Este repositorio contiene una aplicación de prueba que implementa los servicios de Test de Mercadolibre. La implementación de la arquitectura esta basada en MVVM usando Kotlin,  ViewModel
LiveData
Corrutinas
Dagger Hilt
Navigation
Coil


## Capas - paquetes (Layer)

1. data : Contiene los paquetes asociados al modelo y a la capa de network
  - MODEL: Modelos de negocios asociados a los servicios, para este ejemplo Producto
  - network: Capa que contiene el ApiService
  - repository: Para este ejemplo contiene unicamente un llamado al api service ya que no hay datos locales implementados


2. domain: Casos de uso - (Negocio)

3. ui - presentation 
    - adpaters
    - VIEW: fragments - activities
    - VIEWMODEL: Conexión entre la vista y la capa de negocio.

4. utils: Clases de extrensión y usos comunes dentro de la app, conversión de valores, etc..

5. di: Provider con el module del api service (dagger hilt)
    

** En este proyecto, se caga un vista con un SeachView que permite buscar un producto, finalizada la busqueda se muestra una lista de prodcutos y al seleccionar se muestra el detalle del mismo. 

# Problemas comunes

1. Es posible que al sincronizar el proyecto las dependencia de retrofit2:converter-gson marque error de importación en:

```
import com.google.gson.annotations.SerializedName

@SerializedName("---")...

```

Sin embargo el proyecto commpila, es posible que tengas que borrar cache en Android studio


2. Es posible que al sincronizar el proyecto las dependencia de  testImplementation "com.google.truth:truth:1.1" marque error de importación en:


```
import com.google.common.truth.Truth.assertThat

assertThat...

```

# Issues

- Cualquier issue, duda o consulta lo puede dejar en este link [https://github.com/Aramis11/tenlog_group/issues](https://github.com/Aramis11/tenlog_group/issues) 
