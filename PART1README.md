# Recipe Favorites
## Parte 1 del laboratorio
#### Link del video de explicación: https://drive.google.com/file/d/1-VRB_6XbN8ZIDtW3nZqTbHW6ZKaHdG2u/view?usp=drive_link 
En esta parte se añadio la opción de añadir una receta generada a favoritos y la opción para unicamente mostrar las recetas marcadas como favorito en la app, alternando entre todas
las recetas y unicamente las favoritas, a la vez que se vinculo el proyecto con Firebase y con la API de Gemini para permitir el ingreso de sesión y guardado de datos junto a
la posibilidad de generar las recetas con Gemini en base a una foto.

## Definition of Done

| Criterio              | Descripción                                                       |
|-----------------------|------------------------------------------------------------------|
| Modelo actualizado     | `Recipe` tiene el campo `isFavorite`: Boolean                   |
| Sincronización Firestore | `toggleFavorite()` actualiza el documento en Firestore          |
| Icono de corazón visible | Cada tarjeta de receta muestra un corazón lleno o vacío        |
| Función de toggle      | Tocar el corazón actualiza el estado y se sincroniza en la nube |
| Filtro existente       | El usuario puede cambiar a la vista "Solo favoritos"            |
| Actualización en tiempo real | Los cambios se reflejan inmediatamente (listener de Firestore) |
| UI optimista           | El corazón cambia instantáneamente y revierte en caso de error   |
