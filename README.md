[![Java CI with Maven](https://github.com/andylvua/JavaLabs/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/andylvua/JavaLabs/actions/workflows/maven.yml)
# Лабораторна робота 2
## Опис завдання
1. Реалізувати ієрархію класів до завдання з лабораторної №2 (секція Зимова школа)
2. При записі програми потрібно використовувати домовленості щодо оформлення коду java code convention.
3. Класи потрібно грамотно розкласти по пакетах.
4. Робота з консоллю або консольне меню повинні бути мінімальними.
5. Важливо: необхідно реалізувати лише ієрархію класів, код пошуку елементів у списках чи колекціях не входить у 2-гу роботу
6. Також слід створити обʼєкти реалізованих вами класів у окремому класі Main, який міститиме main метод
7. Слід додати своє прізвище в таблицю до завдання 2 коло обраного варіанту (обирати слід самостійно)
8. Якщо вільних варіантів в документі більше не буде - слід написати викладачу та отримати варіант від нього

# Лабораторна робота 3
## Опис завдання
1. Необхідно створити клас - Менеджер, що міститиме логіку (приклад для варіанту 1):
> Реалізувати пошук товарів, котрі можна купити для дівчинки в осінній період та реалізувати можливість сортування знайдених товарів:
> - за ціною
> - за розмірами
> <!-- end -->
> <br/>
> Реалізація сортування має передбачати можливість сортувати як за спаданням, так і за зростанням.



2. Для сортування слід використати вбудовані методи сортування, доступні в мові Java
3. Сортування слід реалізувати в окремому методі
4. Код немає містити статичних методів/атрибутів. Дозволено лише один статичний метод - void
5. Код має використовувати перелічувальний тип (Enum) (за потреби)

# Лабораторна робота 4
## Опис завдання
Перетворити проєкт з кодом 2-3 роботи таким чином, щоб його збірку можна було виконувати з-за допомоги maven.

При цьому варто зробити команду merge попередніх робіт в master

**Важливо**: збірку проєкту слід виконувати з консолі командою mvn clean package

Згенерувати pom.xml можна з використанням команди maven (слід виконувати з консолі):
``` java
mvn archetype:generate 
-DgroupId=ua.lviv.iot 
-DartifactId=work 
-Dversion=1.0-SNAPSHOT 
-DarchetypeArtifactId=maven-archetype-quickstart 
-DarchetypeVersion=1.0 
-DinteractiveMode=false
```

# Питання на захист
* this keyword
* super keyword
* final keyword
* Блоки ініціалізації
* enum - why they are used? how they differ from final static fields?
* Interface vs Abstract class
* Inheritance in Java: extends, implements keywords
* Make class abstract
* Make method abstract in Java
* Create interface in Java
* how to make variable to be a constant
* Constructors vs initialization blocks
* What is immutability?
* Explain what is package in Java
* What happens when the main() isn't declared as static?
* What is the difference between JDK, JRE, and JVM?
* Can a constructor return a value?
* Explain Method Overloading in Java. Provide an example based on your code
* Can we overload a static method?
* Why is the delete function faster in the linked list than an array?
* What is pom.xml?
* Explain pom.xml sections
* How to add new dependency in pom.xml?
* How maven dispatches dependencies?
