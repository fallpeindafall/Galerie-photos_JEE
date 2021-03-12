# Gestion Galerie photos
 
L'objectif est de concevoir une application Web qui gère des albums photos d’utilisateurs avec JEE. 
# Profils
 - administrateur
 - utilisateur simple
# Description
Un visiteur du site pourra, sans être authentifié, voir les photos qui sont en accès libre.
Les photos sont placées dans des albums permettant de grouper les photos d’un même thème (vacance, sport, etc.).
Un album peut être déclaré public ou privé. Si l’album est privé, seuls les utilisateurs enregistrés et
autorisés par le propriétaire de l’album peuvent le consulter. S’il est public, il est accessible à tous les
utilisateurs et à tous les visiteurs, même ceux qui ne sont pas identifiés. Seul le propriétaire de l’album
peut faire des modifications (insertion d’images, suppression d’images, modification d’images). Enfin, un
utilisateur peut créer autant d’albums qu’il souhaite.
Une image appartient nécessairement à un album. De ce fait, elle appartient également à un utilisateur
(le propriétaire de l’album). Elle possède un titre, une description, une hauteur et une largeur, des motsclés,
une date de création et une date de mise à jour, et bien sûr, un fichier image. Lors de la présentation de la liste des images,
si on clique sur l’image, elle s’affiche sous forme de popup. Si on clique sur le nom de l’album à laquelle elle appartient, 
le détail de l’album s’affiche, et si on clique sur le nom de l’image,
les informations concernant l’image s’affichent.
Les utilisateurs de l’application sont de deux types : les administrateurs et les utilisateurs simples. En effet,
les visiteurs qui s’inscrivent deviennent des utilisateurs simples et peuvent ainsi publier des albums et des
photos. Quant aux administrateurs, en plus de partager des albums, ils ont la possibilité de gérer les
utilisateurs. Ainsi, ils peuvent ajouter, modifier ou supprimer des utilisateurs ainsi que tous les albums et
photos qui leur sont associés. Toutefois, un compte administrateur ne peut être créé que par un
administrateur. Ce qui veut dire qu’au moins un administrateur devra préalablement être inscrit dans
l’application.
