# Stormtroopers : Clean Architecture + MVVM ( kotlin )
<b>Le Scenario :</b> Cette application contient deux pages en totales. La premiere montre une liste d'information et la deuxieme le detail. le défi que j'ai choisi pour ce projet était d'implementer correctement la Clean Archi+ MVVM en utilisant les éléments de Jetpack au maximum.J'ai aussi implementé Rx(l'outil de Reactive Programming) au cas du besoin et Dagger2 (l'outil de Dependency Injection).<br><br>
<b>Language:</b>
Ce project a été implemente en kotlin. En utilisant les fonctionallités de ce language un peu partout, on profite de ses avantages (extension, data class , null safety, functional,…)
<br><br>

<b>Arcitecture: </b>
Le project a été implemente en clean architecture + mvvm. Les principes de SOLID a été respecté au maximum. 
<br>
Le project consiste quatre packages : 
- app (dependency : presentation, domain, data)
- presentation(dependency : domain)
- domain(dependency : aucune)
- data(dependency : domain)
<br>
-La partie “app” contient tout ce qui est  “view”: Activity, Fragment, Dialog, xml ,etc.<br>
-Presentation contient les viewmodel. Ici nous avons just une viewmodel(TripsViewModel). Dans cette class on demande ce qu’on a besion des usecase du package domain. 
<br>-Domain : Il n’y a aucune dependency dans ce package. Ici on sait ce qu’on veut mais on ne sait pas comment!
<br>-Data : Dans ce package on sait comment implementer ce qu’on veut! On a acces au database et aux api.
On peut avoir de parties : locale et api. Dans notre projet on a acces aux api. La partie cache a été également prévu mais nous n’avons pas vraiment besoin pour ce petit projet.
<br><br><b>Outils et Libraries:</b><br>
<br>-Retrofit est la librairie de "networking". Il est utliisé pour contenir les fonctionnalités de rx.
<br>-Rx a été implementé pour faire des requetes et aussi pour convertir/filter quelques strings.
<br>-Pour "depenednecy injection" j’ai utitlisé Dagger 2.
<br>-Navigation comme outil de jetpack a été impelementé pour pouvoir naviger facilement entre les fragment.
<br>-Picasso: comme l’outil d’image.
<br>-Les tests ont été implemente en utilisant mockito.
<br>-Constaintlayout a été utilise pour implementer correctement les UI demande.
<br>-LiveData a été implemente comme outil de connexion entre view et viewmodel. Il "notify" la View une fois qu’il a un resultat.


