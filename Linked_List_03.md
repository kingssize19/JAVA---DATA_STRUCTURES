# ÇİFT YÖNLÜ DOĞRUSAL BAĞLI LİSTE 

## Node Sınıfı :

```java
package com.hayati.cift_yonlu_dogrusal_bagli_liste;

public class Node {
    
    int data;
    Node next;      //sonraki elemanı gösterir.
    Node prev;      //önceki elemanı gösterir.
    
    
    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
    
}
```
Kod, bir Node sınıfına dayanıyor. Çift yönlü bağlı liste için her Node şunları içerir.
* **data :** Düğümdeki veri.
* **next :** Bir sonraki düğümü işaret eden referans.
* **prev :** Bir önceki düğümü işaret eden referans.


## List Sınıfı :

```java
package com.hayati.cift_yonlu_dogrusal_bagli_liste;

public class List {
    
    //çift yönlü doğrusal bağlı liste yapısı
    
    Node head = null;
    Node tail = null;
    
    void basaEkle(int data) {
        
        Node eleman = new Node(data);
        
        if (head == null) {
            head = eleman;
            tail = eleman;
        }
        else {
            eleman.next = head;
            head.prev = eleman;
            head = eleman;
        }
        
    }
    
    void sonaEkle(int data) {
        
        Node eleman = new Node(data);
        
        if (head == null) {
            head = eleman;
            tail = eleman;
        }
        else {
            eleman.prev = tail;
            tail.next = eleman;
            tail = eleman;
        }
        
    }
    
    void arayaEkle(int idx,int data) {
        
        Node eleman = new Node(data);
        
        if (idx < 0 ) {
            System.out.println("Hata : Gecersiz Indeks (Negatif Index).");
            return;
        }
        
        if (head == null) {
            head = eleman;
            tail = eleman;
            return;
        }
        else if (head != null && idx == 0) {
            eleman.next = head;
            head.prev = eleman;
            head = eleman;
            return;
        }
        
        Node temp = head;
        
        int count = 0;
        
        while (temp != null) {
            temp = temp.next;
            ++count;
        }
        
        if (idx >= count) {
            tail.next = eleman;
            eleman.prev = tail;
            tail = eleman;
                      
        }
        else {
            int i = 0;
            temp = head;
 
            while (i != idx) {
                temp = temp.next;
                ++i;
            }
            
            eleman.prev = temp.prev;
            temp.prev.next = eleman;
            eleman.next = temp;
            temp.prev = eleman;
            
        }
       
    }
    
    
    void yazdir() {
        
        Node temp = head;
        
        System.out.print("bas -> ");
        
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" son.");
        
    }
    
    void sondanYazdir() {
        Node temp = tail;
        
        System.out.print("son -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println(" bas.");
        
        
    }   
}
```

* **head :** Listenin başını işaret eden düğüm.
* **tail :** Listenin sonunu işaret eden düğüm.
* Her düğüm, hem kendisinden önceki düğümü hem de kendisinden sonraki düğümü bilir. Bu, listenin çift yönlü yapısını oluşturur.


## 1. basaEkle(int data)

Bağlı listenin başına bir düğüm ekler.
```java
void basaEkle(int data) {
    Node eleman = new Node(data);

```
* **Node eleman = new Node(data);  :** Yeni bir düğüm (eleman) oluşturulur ve içine data verisi yerleştirilir.
* DÜğüm şu anda yalnızca kendi verisini içerir. next ve prev referansları null durumundadır.

```java
    if (head == null) {
        head = eleman;
        tail = eleman;
    }
```
* Eğer liste boşsa (head == null) :
  * head ve tail, yeni düğümü işaret eder. Bu, listenin ilk elemanını oluşturur.
  * Yeni düğümün next ve prev referansları null olarak kalır.

```java
    else {
        eleman.next = head;
        head.prev = eleman;
        head = eleman;
    }
```
* Eğer liste boş değilse :
  * Yeni düğümün next referansı, mevcut baş düğümü (head) işaret eder.
  * Mevcut baş düğümün (head) prev referansı, yeni düğümü işaret eder.
  * Yeni düğüm, listenin yeni başı olur (head = eleman).

### Örnek : 
**Başlangıçta liste boş :**
* **basaEkle(10) :** head ve tail aynı düğümü (10) işaret eder.
* **basaEkle(20) :**
  * 20 yeni baş düğüm olur.
  * 20.next -> 10 ve 10.prev -> 20


-------------------------------------------------------------------------------------------------------------

## 2. sonaEkle(int data)

**Bağlı listenin sonuna bir düğüm ekler.**

```java
void sonaEkle(int data) {
    Node eleman = new Node(data);
```
* **Node eleman = new Node(data);  :** Yeni bir düğüm oluşturulur.

```java
    if (head == null) {
        head = eleman;
        tail = eleman;
    }
```
* **Eğer liste boşsa :**
  * Yeni düğüm hem head hemde tail olarak atanır.

```java
    else {
        eleman.prev = tail;
        tail.next = eleman;
        tail = eleman;
    }
```
* **Eğer liste boş değilse :**
  * Yeni düğümün prev referansı, mevcut son düğümü (tail) işaret eder.
  * Mevcut son düğümün (tail) next referansı, yeni düğümü işaret eder.
  * Yeni düğüm, listenin yeni son düğümü olur (tail = eleman).

### Örnek :

**Başlangıçta liste 10 -> 20 :**
* **sonaEkle(30) :**
  * 30 yeni son düğüm olur.
  * 20.next -> 30 ve 30.prev -> 20

-------------------------------------------------------------------------------------------------------------

## 3. arayaEkle(int idx, int data)

**Belirtilen indeks konumuna bir düğüm ekler.**

```java
void arayaEkle(int idx, int data) {
    Node eleman = new Node(data);
```
* Yeni bir düğüm oluşturulur.

```java
    if (idx < 0) {
        System.out.println("Hata : Gecersiz Indeks (Negatif Index).");
        return;
    }
```
* Eğer indeks negatifse, hata mesajı yazdırılır ve işlem sonlandırılır.

### Liste Boşsa :

```java
    if (head == null) {
        head = eleman;
        tail = eleman;
        return;
    }
```
* Yeni düğüm, hem head hem de tail olarak eklenir.


### Başlangıca Ekleme (idx == 0)

```java
    else if (head != null && idx == 0) {
        eleman.next = head;
        head.prev = eleman;
        head = eleman;
        return;
    }
```
* Eğer indeks 0 ise :
  * Yeni düğümün next referansı mevcut baş düğümü işaret eder.
  * Mevcut baş düğümün prev referansı, yeni düğümü işaret eder.
  * Yeni düğüm, listenin yeni başı olur (head = eleman).


### Listeyi Dolaşarak Konum Bulma

```java
    Node temp = head;
    int count = 0;
    while (temp != null) {
        temp = temp.next;
        ++count;
    }
```
* Liste dolaşılarak toplam eleman sayısı (count) hesaplanır.

### Sona Ekleme (idx >= count)

```java
    if (idx >= count) {
        tail.next = eleman;
        eleman.prev = tail;
        tail = eleman;
    }
```
* Eğer indeks, listedeki düğüm sayısından büyükse :
  * Yeni düğüm sona eklenir (sonaEkle(data) ile aynı işlemler).


### Araya Ekleme :

```java
    else {
        int i = 0;
        temp = head;
        while (i != idx) {
            temp = temp.next;
            ++i;
        }
```
* İstenilen indeks konumuna kadar temp düğümüyle ilerlenir.

```java
        eleman.prev = temp.prev;
        temp.prev.next = eleman;
        eleman.next = temp;
        temp.prev = eleman;
    }
```
* Yeni düğüm, hedef düğümün (temp) öncesine eklenir :
  * Yeni düğümün prev referansı, hedef düğümün önceki düğümünü işaret eder.
  * Önceki düğümün next referansı, yeni düğümü işaret eder.
  * Yeni düğümün next referansı, hedef düğümü işaret eder.
  * Hedef düğümün prev referansı, yeni düğümü işaret eder.

-------------------------------------------------------------------------------------------------------------

## 4. yazdir()

**Bağlı listenin baştan sona elemanlarını yazdırır.**

```java
void yazdir() {
    Node temp = head;
    System.out.print("bas -> ");
    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }
    System.out.println(" son.");
}
```
* head düğümünden başlanarak tüm düğümler dolaşılır.
* Her düğümün data verisi yazdırılır.
* Döngü, temp = temp.next; ile sıradaki düğüme geçer.

-------------------------------------------------------------------------------------------------------------

## 5. sondanYazdir()

**Bağlı listenin sondan başa elemanlarını yazdırır.**

```java
void sondanYazdir() {
    Node temp = tail;
    System.out.print("son -> ");
    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.prev;
    }
    System.out.println(" bas.");
}
```

* tail düğümünden başlanarak tüm düğümler sondan başa doğru dolaşılır.
* Her düğümün data verisi yazdırılır.
* Döngü, temp = temp.prev; ile bir önceki düğüme geçer. 



