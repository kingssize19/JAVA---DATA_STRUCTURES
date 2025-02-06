# JAVA DATA STRUCTURES

**Veri yapıları, verilerin bilgisayar belleğinde organize edilme ve depolanma şeklini ifade eder. Veri yapıları, programlama dillerinde verileri daha verimli bir şekilde işlemek, depolamak ve erişmek için kullanılır. Java, birçok yerleşik veri yapısına sahiptir ve bu yapılar, farklı ihtiyaçlara uygun şekilde tasarlanmıştır.**

# 1. Veri Yapıları Nedir?

* Veri yapıları, verilerin mantıksal ve matematiksel bir düzende organize edilmesini sağlayan yapılardır. Bu yapılar, verilere erişim, ekleme, silme ve güncelleme gibi işlemleri daha hızlı ve verimli hale getirir. Veri yapıları, temel olarak iki kategoriye ayrılır :
  **1. Primitif (Temel) Veri Yapıları :** Java'da **int**, **float**, **double**, **char**, **boolean** gibi temel veri türleri.
  **2. Kompleks (Bileşik) Veri Yapıları :** Diziler (arrays), listeler (lists), yığınlar (stacks), kuyruklar (queues), ağaçlar (trees), grafler (graphs) gibi yapılar.


# 2. Java'da Yaygın Kullanılan Veri Yapıları

* Java, veri yapılarını uygulamak için **Java Collections Framework** adı verilen bir çerçeve sunar. Bu çerçeve, birçok veri yapısını ve algoritmayı içerir. İşte Java'da sıkça kullanılan veri yapıları :

## 2.1. Diziler (Arrays)

* Diziler, aynı türdeki verilerin sabit boyutlu bir koleksiyonudur.
* Bellekte ardışık olarak depolanırlar.
* **Avantajlar :** Hızlı erişim (O(1) zaman karmaşıklığı).
* **Dezavantajlar :** Boyutu sabittir, dinamik olarak genişletilemez.

```java
int[] sayilar = {1, 2, 3, 4, 5};
System.out.println(sayilar[0]);      // 1
```

## 2.2. Listeler (Lists)

* Listeler, dinamik boyutlu veri yapılarıdır.
* **ArrayList :** Dizi tabanlı bir liste. Hızlı erişim sağlar, ancak ekleme/silme işlemleri yavaş olabilir.
* **LinkedList :** Bağlı liste tabanlı bir yapı. Ekleme/silme işlemleri hızlıdır, ancak erişim yavaştır.

```java
import java.util.ArrayList;
import java.util.LinkedList;

ArrayList<String> arrayList = new ArrayList<>();
arrayList.add("Java");
arrayList.add("Python");

LinkedList<String> linkedList = new LinkedList<>();
linkedList.add("C++");
linkedList.add("JavaScript");
```

## 2.3. Yığınlar (Stacks)

* **LIFO (Last In, First Out)** mantığına göre çalışır. Son giren eleman ilk çıkar.
* **push() :** Eleman ekler.
* **pop() :** Eleman çıkarır.
* **peek() :** En üstteki elemanı gösterir.

```java
import java.util.Stack;

Stack<String> stack = new Stack<>();
stack.push("Java");
stack.push("Python");
System.out.println(stack.pop());   // Python
```

## 2.4. Kuyruklar (Queues)

* **FIFO (First In, First Out)** mantığına göre çalışır. İlk giren eleman ilk çıkar.
* **add() veya offer() :** Eleman ekler.
* **remove() veya poll() :** Eleman çıkarır.
* **peek() :** İlk elemanı gösterir.

```java
import java.util.Queue;
import java.util.LinkedList;

Queue<String> queue = new LinkedList<>();
queue.add("Java");
queue.add("Python");
System.out.println(queue.poll());     // Java
```

## 2.5. Kümeler (Sets)

* Benzersiz (tekrarsız) elemanlar içerir.
* **HashSet :** Hızlı erişim sağlar, ancak sıralama yoktur.
* **TreeSet :** Elemanları sıralı tutar.

```java
import java.util.HashSet;
import java.util.TreeSet;

HashSet<String> hashSet = new HashSet<>();
hashSet.add("Java");
hashSet.add("Python");

TreeSet<String> treeSet = new TreeSet<>();
treeSet.add("C++");
treeSet.add("JavaScript");
```

## 2.6. Haritalar (Maps)

* Anahtar-değer (key-value) çiftlerini depolar.
* **HashMap :** Hızlı erişim sağlar, sıralama yoktur.
* **TreeMap :** Anahtarlara göre sıralı tutar.

```java
import java.util.HashMap;
import java.util.TreeMap;

HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("Java", 1);
hashMap.put("Python", 2);

TreeMap<String, Integer> treeMap = new TreeMap<>();
treeMap.put("C++", 3);
treeMap.put("JavaScript", 4);
```

## 2.7. Ağaçlar (Trees)

* Hiyerarşik veri yapısıdır.
* **Binary Tree :** Her düğümün en fazla iki çocuğu vardır.
* **Binary Search Tree (BST) :** Sol alt ağaçtaki değerler küçük, sağ alt ağaçtaki değerler büyüktür.

## 2.8. Graf (Graphs)

* Düğümler (nodes) ve kenarlardan (edges) oluşur.
* Yönlü (directed) veya yönsüz (undirected) olabilir.
* Ağırlıklı (weighted) veya ağırlıksız (unweighted) olabilir.


# 3. Veri Yapılarının Kullanım Alanları

* **Diziler :** Sabit boyutlu veriler için (örneğin, öğrenci notları).
* **Listeler :** Dinamik veri koleksiyonları için (örneğin, alışveriş listesi).
* **Yığınlar :** Geri alma (undo) işlemleri, fonksiyon çağrı yığınları.
* **Kuyruklar :** Sıralı işlemler (Örneğin, yazıcı kuyruğu).
* **Kümeler :** Benzersiz veriler için (örneğin, kullanıcı kimlikleri).
* **Haritalar :** Anahtar-değer ilişkileri (örneğin, sözlük uygulaması).
* **Ağaçlar :** Hiyerarşik veriler (örneğin, dosya sistemi).
* **Graf :** Ağ yapıları (örneğin, sosyal ağlar, harita uygulamaları).


# 4. Veri Yapılarının Performans Analizi

| **Veri Yapısı** | **Ekleme** | **Silme** | **Erişim** | **Arama** |
|--|--|--|--|--|
| Dizi (Array)	| O(n) |	O(n)	| O(1) |	O(n) |
| ArrayList	| O(1)* |	O(n) |	O(1)	| O(n) |
| LinkedList |	O(1) |	O(1) |	O(n) |	O(n) |
| Stack |	O(1) |	O(1) |	O(1) |	O(n) |
| Queue	| O(1)	| O(1)	| O(1)	| O(n) |
| HashSet	| O(1)*	| O(1)*	| -	| O(1)* |
| TreeSet	| O(log n) |	O(log n)	| -	| O(log n) |
| HashMap	| O(1)*	| O(1)*	| -	| O(1)* |
| TreeMap	| O(log n) |	O(log n)	| -	| O(log n) |






















