Cedran BASTIEN
Guillaume RETTER

difficultés rencontrées lors du tp : 
La plus grosse difficulté rencontrée lors du tp était de corriger les toutes petites fautes de programmation dans notre
code. Ce sont toujours à cause d'elles que les projets prennent plus de temps que prévu. Sinon dans l'ensemble il n'y a
eu aucun souci majeur ou particulier.

descriptif du lancement de notre application : 
Il faut lancer le programme MainLaby avec un seul argument qui est le nom du labyrinthe que vous voulez charger/jouer.
Après cela il suffira de suivre les instructions afficher dans le terminal qui s'ouvrira. Et si vous voulez arrêter l'application
il faudra taper : "exit" dans le terminal.

résumé des résultats des tests : 
toutes les méthodes ont été testé et les tests en relation marchent. Les exceptions ont été aussi testé dans les cas où 
elles devraient apparaître.
Le programme a aussi été testé pour tous les labyrinthes en plus de deux labyrinthes supplémentaires qui sont mal
formés. Les tests en relation marchent aussi.

explication de la couverture de test :
Lorsqu'on lance la couverture de test on voit que pour chaque classe dans le src il y a un pourcentage qui indique 
si la classe a tété testé, le nombre de méthodes testées et le nombre de lignes testées. 
Or pour notre couverture de test les classes sont toutes à 100% à part MainLaby et TestLaby. MainLaby est notre classe
de lancement/fonctionnement de notre labyrinthe et TestLaby sont les tests donnés par les professeurs.
Toutes les méthodes ont été testé pour les classes Personnage, Sortie, Position et TestLabyEtudiant. Les méthodes de la classe Labyrinthe
a été testé à 90% car on n'a jamais utilisé un getter (getMurs) qu'on avait mis au cas où on aurait dû s'en servir. Les méyhodes
des exceptions n'ont pas été testé.
Le pourcentage en terme de ligne pour chaque classe est donc : 
 - ActionInconnueException : 50%
 - FichierIncorrectException : 50%
 - Labyrinthe : 98%
 - MainLaby : 0%
 - Personnage : 100%
 - Sortie : 100%
 - Position : 100%
 - TestLaby : 0%
 - TestLabyEtudiant : 100%