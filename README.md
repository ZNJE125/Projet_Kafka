# Projet_Kafka

Ce fichier explique comment lancer l'application.

Pour cela il faut avoir installé au préalable zookeeper et kafka.

Rendez vous dans le dossier ou se trouve ces deux derniers.

lancer la commande suivante : 






Une fois ceci fait vous pouvez démarrer l'API Spring boot.


Pour tester les appels vous pouvez utiliser POSTMAN.


L'endpoint pour créer un document est :
/documents/get/identifiant


L'endpoint pour voir un document est :
/document/create

les informations du document sont à renseigner dans le body de la requete



vous ne pouvez voir qu'un document avec son id.


L'endpoint pour supprimer un docment est : /documents/delete/identifiant
elle ne marche pas si l'id n'existe pas



