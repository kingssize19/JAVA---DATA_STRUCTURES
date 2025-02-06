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


