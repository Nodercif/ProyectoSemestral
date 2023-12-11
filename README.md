# ProyectoSemestral
Este es el proyecto semestral del curso de programacion II en la universidad de Concepción. Corresponde al grupo numero 22 que consiste de:
Felicia Pino y Gabriela Muñoz
Este proyecto consiste en la simulación de un zoologico, con distintos habitats y animales. Los animales solo pueden sobrevivir en habitats con con cualidades apropiadas.
En la propuesta original se dictaba que no fuera posible colocar un animal en un habitat inadecuado, pero hemos decidido que si sea posible y este fallezca despues de un tiempo.
Con respecto a patrones, el unico patron que utilizamos fue el singleton. Este lo ocupamos varias veces a lo largo del proyecto. Tenemos el singleton ZooManager, que manega las compras y el dinero del zoologico. Lo ocupamos tambien en clases que cargan informacion de archivos, para que asi se pueda acceder a esta informacion y solo se lea la primera vez que se necesite y despues quede guardada en la clase. Ejemplos de esto son las InformacionVisitantes e InformacionCaminos.

Durante el desarrollo de este proyecto tuvimos que hacer deciciones acerca de el diseño de la interfaz y como distintas clases se van a comunicar. En un punto consideramos juntar todos los paquetes en uno ya que no se nos ocurria una forma de manejar la comunicacion entre los animales logicos y visuales. Despues de harta deliveracion pudimos encontrar una manera de mantenerlo asi, llevando buena cuenta de cuando se crean y nuevos animales, pudimos lograr que todos los animales visuales esten sincronizados con su contraparte logica.
Mientras estabamos haciendo este proyecto, nos encontramos con un bug muy complicado, en el que el menu de compra no se desplegaba cuando debia hacerse. Nos dimos muchas vueltas y nos dio mucho dolor de cabeza. Al dia siguiente, viendo otra parte del programa nos dimos cuenta cual era el error. Este estaba en una parte distinta del programa de donde esperabamos inicialmente.
![El increible zoologico digital](https://github.com/Nodercif/ProyectoSemestral/assets/59321776/0e9e7154-ccf2-4b65-97d0-d1bc9f182971)

[El increible zoologico digital.pdf](https://github.com/Nodercif/ProyectoSemestral/files/13630452/El.increible.zoologico.digital.pdf)

![capturaDePantalla](https://github.com/Nodercif/ProyectoSemestral/assets/59321776/bd34a14b-88f0-442a-abbb-e9656d86bb64)
