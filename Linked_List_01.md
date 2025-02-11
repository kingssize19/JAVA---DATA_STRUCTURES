Kod 3 temel bileşene ayrılmıştır : 
1. **Node Sınıfı :** Bağlı listenin her bir elemanını temsil eder.
**2. List Sınıfı :** Bağlı listeyi yönetmek ve düzenlemek için kullanılan metotları içerir.
**3. Main Metodu :** Bağlı listeyi test etmek ve çalışmasını görünür hale getirmek için kullanılır.

## 1. Node Sınıfı

```java
public class Node {
      int id;
      String name;
      Node next;
}
```
**Amaç :** Bu sınıf, bağlı listenin her bir elemanını temsil eder ve üç temel bileşenden oluşur :
* **id :** Her düğümün benzersiz kimliğini tutar.
* **name :** Düğümün isim değerini içerir.
* **next :** Bir sonraki düğümü işaret eden referanstır.

Her düğüm, kendisinden sonraki düğüme next referansı ile bağlanır. Bu yapı, bağlı listenin temelini oluşturur.

## 2. List Sınıfı 

```java
public class List {
      Node head = null;
      Node tail = null;
}
```
* **Amaç :** Bu sınıf, bağlı listeyi yönetir ve listenin başlangıç (head) ile son (tail) düğümlerinin referanslarını tutar.
* **head :** Listenin ilk elemanını işaret eder.
* **tail :** Listenin son elemanını işaret eder.

## 3. List Metotları

### 3.1. basaEkle(int id, String name)

**Mantığı :**
* Eğer liste **boş** ise :
  * Yeni düğüm (Node) hem head (baş) hem de tail (son) olur.
  * Bu, listenin ilk elemanını oluşturur.

* Eğer liste **boş değilse** :
  * Yeni düğüm, mevcut head düğümünü işaret eder (eleman.next = head).
  * Sonra, yeni düğüm head olarak güncellenir.

**Kod Analizi :**
```java
public void basaEkle(int id, String name) {
    Node eleman = new Node();  // Yeni düğüm oluşturuluyor.
    eleman.id = id;           // Düğümün id'si atanıyor.
    eleman.name = name;       // Düğümün ismi atanıyor.
    
    if (head == null) {       // Liste boşsa...
        eleman.next = null;   // Yeni düğümün sonraki referansı yok.
        head = eleman;        // Yeni düğüm hem baş hem son oluyor.
        tail = eleman;        // Tail de aynı düğümü işaret eder.
        System.out.println("Liste yapisi olusturuldu ilk eleman eklendi.");
    } else {                  // Liste boş değilse...
        eleman.next = head;   // Yeni düğüm, mevcut baş düğümü işaret eder.
        head = eleman;        // Yeni düğüm başa alınır.
        System.out.println("Basa eleman eklendi.");
    }
}
```
**Örnek Kullanım :**
```java
liste.basaEkle(0, "Hayati");
```
**Sonuç :**
* Eğer liste boş ise :
  * Liste şu şekilde olur : \[Hayati\]
* Eğer liste doluysa (örn. \[A, B, C\]) :
  * Yeni düğüm Hayati, başa eklenir : \[Hayati, A, B, C\]

-----------------------------------------------------------------------------------

## 3.2. sonaEkle(int id, String name)

**Görevi :** Listenin sonuna yeni bir düğüm ekler.

**Mantığı :**
* Eğer liste **boş** ise :
  * Yeni düğüm listenin ilk elemanı olarak eklenir (head ve tail olarak ayarlanır).

* Eğer liste **boş değilse** :
  * Mevcut tail düğümü, yeni düğümü işaret eder (tail.next = eleman).
  * Sonra, tail yeni düğümü işaret eder.

```java
public void sonaEkle(int id, String name) {
    Node eleman = new Node();  // Yeni düğüm oluşturuluyor.
    eleman.id = id;           // Düğümün id'si atanıyor.
    eleman.name = name;       // Düğümün ismi atanıyor.
    
    if (head == null) {       // Liste boşsa...
        eleman.next = null;   // Yeni düğümün sonraki referansı yok.
        head = eleman;        // Yeni düğüm hem baş hem son oluyor.
        tail = eleman;
        System.out.println("Liste yapisi olusturuldu ilk eleman eklendi.");
    } else {                  // Liste boş değilse...
        eleman.next = null;   // Yeni düğümün `next` referansı null.
        tail.next = eleman;   // Tail'deki düğüm, yeni düğümü işaret eder.
        tail = eleman;        // Yeni düğüm tail olarak atanır.
        System.out.println("Sona eleman eklendi.");
    }
}
```
**Örnek Kullanım :**
```java
liste.sonaEkle(1, "Sevgi");
```
**Sonuç :**
* Eğer liste boş ise :
  * Liste şu şekilde olur : \[Sevgi\]

* Eğer liste dolu ise (Örn. \[A, B, C\])
  * Yeni düğüm Sevgi, sona eklenir : \[A, B, C, Sevgi\]

-----------------------------------------------------------------------------------

## 3.3. arayaEkle(int idx, int id, String name)

**Görevi :** Belirtilen indeksin (idx) öncesine yeni bir düğüm ekler.
**Mantığı :**
* Eğer liste **boş** ve indeks sıfır ise :
  * Yeni düğüm listenin ilk elemanı olur.

* Eğer indeks sıfır ise :
  * **basaEkle** işlevine benzer şekilde, yeni düğüm listenin başına eklenir.

* Eğer liste dolu ve indeks sıfırdan büyükse :
  * Belirtilen indekse kadar liste dolaşılır.
  * Düğümler arasındaki bağlantılar güncellenir.
    * Yeni düğümün next özelliği, belirtilen indeksteki düğümü işaret eder.
    * Yeni düğümü, önceki düğüm işaret eder.

**Kod Analizi :**
```java
public void arayaEkle(int idx, int id, String name) {
    Node eleman = new Node();  // Yeni düğüm oluşturuluyor.
    eleman.id = id;
    eleman.name = name;

    if (head == null && idx == 0) {  // Liste boşsa ve indeks sıfırsa...
        eleman.next = null;
        head = eleman;
        tail = eleman;
        System.out.println("Liste yapisi olusturuldu ilk eleman eklendi.");
    } else if (head != null && idx == 0) {  // Liste dolu ve indeks sıfırsa...
        eleman.next = head;
        head = eleman;
        System.out.println("0. idx e eleman eklendi.");
    } else {
        Node temp = head;
        Node temp2 = head;
        int i = 0;

        // Belirtilen indekse kadar liste dolaşılıyor.
        while (i != idx) {
            temp2 = temp;
            temp = temp.next;
            ++i;
        }

        temp2.next = eleman;  // Yeni düğüm, önceki düğümü işaret eder.
        eleman.next = temp;   // Yeni düğümün `next` referansı ayarlanır.
        System.out.println(idx + ". siraya yeni eleman eklendi.");
    }
}
```
**Örnek Kullanım :**
```java
liste.arayaEkle(2, 2, "Baki");
```
**Sonuç :**
* Eğer liste \[A, B, C\] şeklindeyse :
  * Yeni düğüm belirtilen konuma eklenir : \[A, B, Baki, C\]

-----------------------------------------------------------------------------------

## 4. yazdir()

**Görevi :** Listenin tüm düğümlerini ekrana yazdırır.
**Mantığı :** 
* Eğer liste **boş** ise :
  * Kullanıcıya "Liste yapısı boş" mesajı verir.
* Eğer liste dolu ise :
  * Baştan sona tüm düğümler dolaşılır ve her birinin id ve name bilgileri ekrana yazdırılır.

**Kod Analizi :**
```java
public void yazdir() {
    if (head == null) {  // Liste boşsa...
        System.out.println("Liste Yapisi Bos...");
    } else {
        Node temp = head;  // Geçici değişken ile liste dolaşılıyor.
        while (temp != null) {
            System.out.print(temp.id + " ");
            System.out.println(temp.name);
            temp = temp.next;  // Sonraki düğüme geçiliyor.
        }
    }
}
```
**Örnek Kullanım :**
```java
liste.yazdir();
```

**Sonuç :**
* Eğer liste \[A, B, C\] şeklindeyse :
  * Çıktı şu şekilde olur :
    * 0 A
    * 1 B
    * 2 C

## 5. Genel İşleyiş Mantığı 

**1. Node Yapısı :** Her bir düğüm, bir id, bir name ve bir next referansı içerir. next, bir sonraki düğümü işaret eder.
**2. Baş ve Son :** Listenin head ve tail referansları, sırasıyla ilk ve son düğümü işaret eder.
**3. Fonksiyonlar :** Kullanıcıya listenin başına, sonuna veya belirli bir pozisyona düğüm ekleme yeteneği sağlar.
**4. Bağlantılar :** Yeni düğümler eklenirken eski düğümlerin bağlantıları korunur.


























