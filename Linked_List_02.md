# TEK YÖNLÜ DOĞRUSAL BAĞLI LİSTE 

Bu dosyada 3 farklı silme fonksiyonu yer alıyor. Her biri, tek yönlü bağlı listede belirtilen konumdan bir elemanı silmek için kullanılıyor : **baştan silme**, **sondan silme**, **aradan (belirtilen indeksten) silme**. 

## 1. bastanSil() - Baştan Silme Fonksiyonu

**Görevi :** Bağlı listenin başındaki elemanı siler.

**Kod İncelemesi :**
```java
if (head == null) {
    System.out.println("Liste bos!! Silinecek nesne yok.");
}
```
* Eğer head null ise, liste zaten boş demektir. Bu durumda, kullanıcıya listede silinecek bir eleman olmadığını belirtir.

```java
else if (head.next == null) {
    head = null;
    tail = null;
    System.out.println("Listede kalan son eleman silindi.");
}
```
* Eğer head.next null ise, bu, listede yalnızca bir eleman olduğu anlamına gelir.
* Bu durumda, hem head hem de tail null yapılır ve kullanıcıya son elemanın da silindiği belirtilir.


```java
else {
    head = head.next;
    System.out.println("Bastaki eleman silindi.");
}
```
* Eğer listede birden fazla eleman varsa, head bir sonraki düğüme (head.next) kaydırılır.
* İlk eleman bu şekilde "Head" olmaktan çıkar ve dolayısıyla silinmiş olur.

**Genel İşleyiş :**
1. **Liste boşsa :** Silme işlemi yapılmaz.
2. **Listede tek eleman varsa :** O eleman silinir ve liste boş hale gelir.
3. **Listede birden fazla eleman varsa :** head bir sonraki elemanı işaret eder ve ilk eleman silinmiş olur.

------------------------------------------------------------------------------------------------------------

## 2. sondanSil() - Sondan Silme Fonksiyonu

**Görevi :** Bağlı listenin sonundaki elemanı siler.

**Kod İncelemesi :**

```java
if (head == null) {
    System.out.println("Liste bos!! Silinecek nesne yok.");
}
```
* Eğer head null ise, liste zaten boş demektir. Bu durumda, kullanıcıya listede silinecek bir eleman olmadığını belirtir.

```java
else if (head.next == null) {
    head = null;
    tail = null;
    System.out.println("Listede kalan son elemanda silindi.");
}
```
* Eğer head.next null ise, listede yalnızca bir eleman olduğu anlamına gelir.
* Bu durumda, hem head hem de tail null yapılır ve kullanıcıya son elemanın da silindiği belirtilir.

```java
else {
    Node temp = head;
    Node temp2 = head;
    
    while (temp.next != null) {
        temp2 = temp;
        temp = temp.next;
    }
    
    temp2.next = null;
    tail = temp2;
    System.out.println("Sondan eleman silindi.");
}
```
* Liste birden fazla eleman içeriyorsa :
  * İki geçici düğüm (temp ve temp2) kullanılır.
  * temp, listenin sonuna kadar ilerlerken, temp2 hep temp'in bir önceki düğümünde kalır.
  * temp.next == null olduğunda temp, son düğüm olur. temp2, sondan bir önceki düğümdür.
  * Sondaki düğüm (temp) silinmek istendiği için, temp2.next null yapılır. Ayrıca tail, temp2 olarak güncellenir.

**Genel İşleyiş :**
1. **Liste boşsa :** Silme işlemi yapılmaz.
2. **Listede tek eleman varsa :** O eleman silinir ve liste boş hale gelir.
3. **Listede birden fazla eleman varsa :** Son eleman silinir, sondan bir önceki eleman tail yapılır.

------------------------------------------------------------------------------------------------------------

## 3. aradanSil(int idx) - Aradan Silme Fonksiyonu

**Görevi :** Belirtilen indekste (idx) bulunan elemanı siler.

**Kod İncelenmesi :**

```java
if (head == null) {
    System.out.println("Liste bos, silinecek birsey yok!!!");
}
```
* Eğer head null ise, liste zaten boş demektir. Bu durumda, kullanıcıya listede silinecek bir eleman olmadığını belirtir.

```java
else if (head.next == null && idx == 0) {
    head = null;
    tail = null;
    System.out.println("listede kalan son elemanda silindi.");
}
```
* Eğer listede tek bir eleman varsa (head.next == null) ve silinmek istenen indeks 0 ise :
  * Bu durumda, hem head hem de tail null yapılır.
  * Liste tamamen boş hale gelir.

```java
else if (head.next != null && idx == 0) {
    head = head.next;
    System.out.println("Bastaki eleman silindi.");
}
```
* Eğer listede birden fazla eleman varsa ve silinmek istenen indeks 0 ise :
  * Bu bastanSil() fonksiyonu ile aynı davranışı sergiler. Yani head, bir sonraki düğüme (head.next) kaydırılır.

```java
else {
    int i = 0;
    Node temp = head;
    Node temp2 = head;
    
    while (temp != null) {
        i++;
        temp2 = temp;
        temp = temp.next;
    }
    
    if (i == idx) {
        temp2.next = null;
        tail = temp2;
        System.out.println("Listedeki son siradaki eleman silindi.");
    }

```
* temp ile listenin tamamı dolaşılır ve i, listenin uzunluğunu hesaplar.
* Eğer idx, listenin son elemanını ifade ediyorsa :
  * temp2.next null yapılır.
  * tail, temp2 olarak güncellenir.

```java
else {
    temp = head;
    temp2 = head;
    
    int j = 0;
    while (j != idx) {
        temp2 = temp;
        temp = temp.next;
        ++j;
    }
    temp2.next = temp.next;
    System.out.println(idx + " indisli eleman silindi.");
}
```
* Eğer idx, son eleman değilse :
  * temp, belirtilen indekse kadar ilerler. temp2, bir önceki düğümde kalır.
  * Silme işlemi, temp2.next = temp.next ifadesiyle gerçekleştirilir. Böylece temp düğümü atlanır.

**Genel İşleyiş :**
1. **Liste boşsa :** Silme işlemi yapılmaz.
2. **idx == 0 ise :** Baştan eleman silinir.
3. **idx son eleman ise :** Sondan eleman silinir.
4. **idx aradaki bir elemanı ifade ediyorsa :** O eleman silinir ve bir önceki düğüm, bir sonraki düğümü işaret eder.





































