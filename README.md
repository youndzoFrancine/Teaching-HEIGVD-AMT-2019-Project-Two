# Teaching-HEIGVD-AMT-2019-Project-Two

Pour ce projet, nous avons conçus, spécifié, implémenté et validé 2 API RESTful considérées comme 2 "micro-services" en utilisant un ensemble de technologies qui s'appuient sur ou complètent les standards java EE. La première application est une API de gestion des cours `gestionCours API` qui permet de gérer les cours d'un utilisateur(inscription, désinscription, laboratoires d'un cours etc..). La deuxième est une application qui permet de gérer des comptes utilisateurs (création, modification, blocage etc..) `Authentication API`

## Dépendances

Java JDK 11 <br/>
Spring Boot <br/>
Maven <br/>
Springa Data <br/>
Mysql 5.7.15 <br/>
Swagger (Open API) 3.0<br/>
JSON Web Tokens (JWT) <br/>
Maven <br/>
CucumberJVM <br/>

## Architecture

Nous avons implemeté deux projets Spring Boot, chacun produisant un fichier .jar différent. Dans le dossier `docker/topologie` nous avons le `.yaml` qui mets a disposition :
- un conteneur avec le back-end authentication **backend-auth**
- Un conteneur avec le back-end gestion des cours **backend-gestioncours**.
- Un conteneur avec la base de donnée pour le premier back-end. - Un conteneur avec la base de donnée pour le second back-end.
- Un conteneur avec Traefik, agissant comme un proxy inverse dynamique

## Starter le projet

Le point de départ du projet se trouve à la racine. il s'agit du script **start.sh** qui nous permet d'automatiser le lancement de l'application. En l'exécutant à l aide de la commande `./start.sh`.....


## Documentation 

[wiki](https://github.com/youndzoFrancine/Teaching-HEIGVD-AMT-2019-Project-Two/wiki)
