# Chat Documentatie

## Getting started

### Installatie

1. Clone de repository

### Chat App API - Cassandra Setup

Deze handleiding leidt je door het instellen van een Cassandra container voor de Chat App API met behulp van Docker. We gebruiken omgevingsvariabelen om de container te configureren en de benodigde keyspace en tabel voor de applicatie te maken.

#### Vereisten

- [Docker](https://www.docker.com/products/docker-desktop) geïnstalleerd op je computer.

#### Stap 1: Haal de Cassandra Docker-image op

Open een terminal en voer het volgende commando uit om de nieuwste Cassandra Docker-image op te halen:

`docker pull cassandra:latest`

#### Stap 2: Start een Cassandra-container

Voer het volgende commando uit om een Cassandra-container te starten met omgevingsvariabelen:

`docker run --name chatmessages-cassandra -p 9042:9042 -e CASSANDRA_DC=datacenter1 -d cassandra:latest`

Dit commando stelt de volgende omgevingsvariabelen in:

- `CASSANDRA_DC`: De naam van het datacenter.

#### Stap 3: Maak verbinding met de Cassandra-container

Wacht, nadat de container draait, een paar minuten tot Cassandra is gestart en maak vervolgens verbinding met behulp van de `cqlsh`-tool:

`docker exec -it chatmessages-cassandra cqlsh`

#### Stap 4: Maak de keyspace

Voer in de `cqlsh`-prompt het volgende commando uit om een keyspace voor de Chat App API te maken:

`CREATE KEYSPACE chatmessages_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};`

Vervang `chatmessages_keyspace` door de gewenste keyspace-naam.

#### Stap 5: Maak de berichten-tabel

Schakel over naar de nieuw gemaakte keyspace door uit te voeren:

`USE chatmessages_keyspace;`

Maak nu de `messages`-tabel met het volgende commando:

`CREATE TABLE messages (
    messageId UUID PRIMARY KEY,
    senderId UUID,
    receiverId UUID,
    timestamp timestamp,
    messageType text,
    textContent text
);`

#### Stap 6: Verlaat cqlsh en controleer of de container draait

Verlaat de `cqlsh`-prompt door `exit` te typen en op Enter te drukken. Controleer of de Cassandra-container draait door uit te voeren:

`docker ps`

#### Stap 7: Configureer de Chat App API

Werk het `application.properties`-bestand in je Chat App API-project bij om de gemaakte keyspace en de juiste Cassandra-contactpunten te gebruiken:

spring.data.cassandra.keyspace-name=chatmessages_keyspace
spring.data.cassandra.contact-points=host.docker.internal
spring.data.cassandra.port=9042

Vervang `chatmessages_keyspace` door de keyspace-naam die je eerder hebt gekozen.

Nu moet je Chat App API in staat zijn verbinding te maken met de Cassandra


### Configuratie


### Starten

## Documentatie

### Diagram

### Functionaliteit

Deze applicatie zorgt voor de opslag van chatberichten. 

### Programmeertaal en Framework

De applicatie is geschreven in Java met het Spring Boot framework.

Er zijn geen specifieke eisen voor het project, die aan de programmeertaal of framework gesteld worden. Ik wil meer kennis opdoen van Java met Spring Boot. 

### Database

Toen ik begon met het project, was het de bedoeling dat de applicatie wereldwijd gebruikt zou gaan worden door duizenden gebruikers tegelijk. Dit zou betekenen dat de applicatie een grote hoeveelheid aan data moet kunnen opslaan. Na wat rondklikken op het ineternet, kwam ik het volgende artikel van Discord tegen: [How Discord Stores Billions of Messages](https://discord.com/blog/how-discord-stores-billions-of-messages). 

Discord heeft in 2017 een blogpost geschreven over hoe zij miljarden berichten opslaan. Zij liepen tegen het probleem aan dat hun gebruikers toenamen op hoog tempo en dat hun database niet mee kon groeien. Daardoor moesten ze opzoek gaan naar een ander database type, die wel dit toenemende aantal gebruikers en hun berichten kon opslaan.

Discord heeft gekozen voor Cassandra. Cassandra is een NoSQL database [Cassandra], vergelijkbaar dus met MongoDB.

Het voordeel van cassandra is dat het eenvoudige meerdere kopieën van data kan opslaan. Dit zorgt ervoor dat wanneer er een storing is in de hoofdopslag (master node) er een andere node met dezelfde opslag er direct mee verder kan. Zo gaat de data niet verloren en merkt de gebruiker niets van de storing.

Ook kan cassandra grote hoeveelheden aan data schrijven zonder dat de performance daalt [(DataStax Developers, 2022)](https://www.youtube.com/watch?v=YjYWsN1vek8). Dit komt omdat cassandra de data verdeeld over meerdere nodes en deze parallel kan schrijven. Aangezien deze database geschikt moet zijn voor chatberichten die live verstuurd en ontvangen moeten worden, is het belangrijk dat deze database snel kan schrijven. Daarbij kan er meer dan een Petabyte aan data opgeslagen worden, zonder dat dit ten koste gaat van de performance.

### API Specificatie

Zie Postman voor de API specificatie.

## Deployment

## Bronnen

[](https://discord.com/blog/how-discord-stores-billions-of-messages)
[](https://cassandra.apache.org/_/cassandra-basics.html)
[](https://www.youtube.com/watch?v=YjYWsN1vek8)