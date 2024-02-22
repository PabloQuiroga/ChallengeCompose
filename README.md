
# Challenge Yape

## Descripcion
En este challenge se intento cubrir los requerimientos brindados para completar el challenge especificado por mail.
Se utilizo para las vistas el paradigma de Jetpack Compose, con una arquitectura Clean utilizando el patron de diseño MVVM.
Se utilizo Hilt para la inyeccion de dependencias asi como Glide para el manejo de imagenes y Retrofit para el consumo de Api


## Librerias
 - Jetpack Compose
 - Hilt
 - Retrofit
 - Glide

## Capturas de pantalla
<img width="376" alt="captureHome" src="https://github.com/PabloQuiroga/ChallengeCompose/assets/12696213/b8a5d492-ffd3-43bf-9157-bd36a2535366">
<img width="384" alt="capturedetailsOne" src="https://github.com/PabloQuiroga/ChallengeCompose/assets/12696213/7332c1e0-0105-47b2-a6fb-ff33086a36a4">
<img width="384" alt="captureDetailsTwo" src="https://github.com/PabloQuiroga/ChallengeCompose/assets/12696213/b5834ee1-7523-4dc2-9520-6f8d3309c041">
<img width="384" alt="captureMap" src="https://github.com/PabloQuiroga/ChallengeCompose/assets/12696213/abc31a85-1e5c-4e34-9e3f-398c6e1f9ef2">


## Servicios web
Se utilizo servicio mock alojado en [mockable.io](https://www.mockable.io) siendo la url base utilizada http://demo9085266.mockable.io/ con su metodo GET "recipes" el cual retorna una lista de objetos de tipo Recipe



## API Reference

#### Get all recipes
```http
  GET /recipes
```

#### Response
```yaml
[
{
    "id": 1234,
    "name": "Pollo a la cerverza",
    "desc": "Te traigo una idea deliciosa y fácil con pollo. Esta vez, incorporé un ingrediente inesperado a la salsa: el melón. Con la dulzura del melón y el picante del ají serrano, esta comida le encantará a toda tu familia. Para una versión menos picante, utiliza pimientos en vez de ají serrano. ¡A todos les encantará!",
    "img": "http://images-gmi-pmc.edge-generalmills.com/039676b9-d523-43b7-906d-b9bffd1aee51.jpg",
    "ingredients": [
      {
        "name": "jugo de naranja, recién exprimido",
        "quantity": "1/4 taza"
      },
      {
        "name": "jugo de lima, recién exprimido",
        "quantity": "1/4 taza"
      },
      {
        "name": "ajo grande, picado",
        "quantity": "1 diente"
      },
      {
        "name": "comino en polvo",
        "quantity": "1/2 cucharada"
      },
      {
        "name": "pechugas de pollo, sin hueso y sin piel",
        "quantity": "1 lb"
      },
      {
        "name": "melón, cortado en pedazos pequeños",
        "quantity": "2 tazas"
      },
      {
        "name": "aji serrano grande, picados finamente",
        "quantity": "2"
      },
      {
        "name": "cebolla blanca, finamente picada",
        "quantity": "1/2 taza"
      },
      {
        "name": "Sal, ",
        "quantity": "a gusto"
      },
      {
        "name": "Pimienta",
        "quantity": "a gusto"
      }
    ],
    "instructions": [
      
    ],
    "servings": 4,
    "values": [
      
    ],
    "category": "",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  }
]
```



## Authors
- [@PabloQuiroga](https://github.com/PabloQuiroga)
