# CriminalRecords
Projekt für M226 (Harald Müller), Zeigt "Straftaten von Verbrecher" an, mit Daten aus einer mysql Datenbank

## Setup
* Java 17
* Funktionierender mysql-Server mit dem Schema und den Daten aus dem SQL-Skript Database/scripts/

## how to run
Am einfachsten ist es, die Applikation mithilfe von Intellij laufen zu lassen. Alternativ kann man auch lokal JavaFX installieren um die Applikation mit Maven zu starten.

## Programmstruktur
Die CrimeApplication-Klasse ist die Hauptklasse in welcher JavaFX gestartet wir. Der CrimeController seuert und handeld jegliche GUI-Inputs. Die Klassen im Ordner databse sind da um Datenbank inputs und outputs zu handeln.
