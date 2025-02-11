Kod 3 temel bileşene ayrılmıştır : 
**1. Node Sınıfı :** Bağlı listenin her bir elemanını temsil eder.
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































