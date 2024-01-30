## Warehouse
Si scriva un programma in Java per la gestione di un magazzino. 

 - Il programma deve leggere da input stringhe multiple che contengono i prodotti da immagazzinare. (Usare Scanner)
 - I prodotti possono essere di tre tipi: tablet, smartphone, notebook.
 - Per ogni prodotto (sia esso tablet, smartphone o notebook) avremo una serie di attributi:
 - Il tipo di dispositivo  (tablet, smartphone o notebook)
 - Il produttore del dispositivo
 - Il modello del dispositivo
 - La descrizione facoltativa del dispositivo
 - La dimensione del display
 - La dimensione dello spazio di archiviazione
 - Il prezzo di acquisto
 - Il prezzo di vendita
 - Id del dispositivo che rappresenti univocamente il dispositivo nel magazzino.
 - Il programma dovrà avere la gestione del carrello in cui l’utente potrà aggiungere un dispositivo al carrello rimuovendolo dalla lista dei dispositivi attualmente in magazzino quando l’operazione di vendita sarà conclusa.
  Si suggerisce l’uso dell’input da tastiera per la selezione delle operazioni da compiere (1. aggiunta a magazzino, 2. scarico merce da magazzino, 3. creazione carrello, 4. aggiunta elemento al carrello, ecc.)

### Il programma dovrà avere una serie di metodi:
#### Ogni metodo dovrà resitutire la lista di dispositivi frutto della ricerca o un errore nel caso in cui la ricerca non produca risultati.

 - Un metodo per la stampa di tutti i dispositivi a magazzino.
 - Un metodo che permetta di fare la ricerca per tipo di dispositivo.
 - Un metodo che permetta di ricercare per produttore
 - Un metodo che permetta di ricercare per modello
 - Un metodo che permetta la ricerca per prezzo di vendita
 - Un metodo che permetta la ricerca per prezzo di acquisto
 - Un metodo che permetta la ricerca in un determinato range di prezzo (esempio da 150.00 a 250.00 euro)
 - Un metodo che calcoli la spesa media di acquisto per singolo dispositivo e che restituisca il valore medio.
 - Un metodo di aggiunta di un elemento al carrello attraverso l’id con relativo aggiornamento del magazzino che restituirà il carrello aggiornato.
 - Un metodo di rimozione di un elemento dal carrello attraverso l’id con relativo aggiornamento del magazzino che restituirà il carrello aggiornato.
 - Un metodo che calcoli il totale del carrello e che restituisca tale valore.
 - Un metodo che finalizzi l’operazione di vendita e rimuova gli elementi definitivamente dal magazzino ed elimini il carrello stesso.
