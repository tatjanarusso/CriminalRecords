# CriminalRecords
Projekt für M226 (Harald Müller), Zeigt "Straftaten von Verbrecher" an, mit Daten aus einer mysql Datenbank

## Setup
### Dependencies
* Java 17
* Docker
* Docker Compose

## how to run
1. Starten Sie die Datenbank mit docker. Dies können Sie tun, indem sie in den Ordner "docker" gehen und dort den Befehl `docker-compose up` eingeben.
2. Am einfachsten ist es, die Applikation mithilfe von Intellij laufen zu lassen. Alternativ kann man auch lokal JavaFX installieren, um die Applikation mit Maven zu starten.

## Programmstruktur
Die CrimeApplication-Klasse ist die Hauptklasse in welcher JavaFX gestartet wir. 
Der CrimeController steuert und handled jegliche GUI-Inputs. 
Die Klassen im Ordner database sind da um Datenbank inputs und outputs zu handeln.
