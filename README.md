# Generateur de mots

Petit programme Java en ligne de commande qui genere un texte a partir des 35 chapitres de *Madame Bovary* de Gustave Flaubert fournis dans `src/bovary/`.

## Fonctionnement

Le programme construit une table de transitions a partir des textes. Avec un ordre de 3, chaque sequence de trois mots est associee aux mots qui la suivent dans le corpus. Il genere ensuite un texte en choisissant aleatoirement une continuation parmi celles observees. La generation commence au debut du corpus et s'arrete lorsqu'une fin de chapitre est atteinte ou qu'aucune continuation n'est disponible.

La ponctuation reste attachee aux mots, car le corpus est lu comme une suite de tokens separes par des espaces.

## Prerequis

- JDK 21 ou plus recent
- Un terminal ouvert a la racine du projet

## Compiler et executer

Depuis le dossier `generateur_mots` :

```sh
javac -d bin src/*.java
java -cp bin Bovary
```

Le programme affiche la construction de la table, puis le texte genere dans le terminal. Le nombre de mots du contexte est actuellement fixe a 3 dans `src/Bovary.java`.

## Structure

```text
src/
  Bovary.java       Point d'entree et generation du texte
  HMap.java         Table des contextes et de leurs continuations
  Prefix.java       Contexte de mots utilise comme cle
  WordReader.java   Lecture des mots du corpus
  WordList.java     Liste chainee de mots
  bovary/           Chapitres 01.txt a 35.txt et licence du corpus
```

Les autres classes (`Entry`, `EntryList`, `Node` et `EqString`) sont des structures ou exemples auxiliaires du projet.

## Corpus et licence

Les textes de *Madame Bovary* proviennent de la base de l'Association des Bibliophiles Universels (ABU). Le fichier `src/bovary/license.txt` contient la licence ABU et les informations de provenance. Conservez cette licence et les en-tetes des textes lors de toute redistribution du corpus. Aucune licence specifique au code Java n'est indiquee dans ce depot.