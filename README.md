# Chat Documentatie

## Getting started

### Installatie

1. Clone de repository


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