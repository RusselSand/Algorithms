# Algorithms

Here are the solutions to the final tasks for the course «Algorithms and data structures».

## 1. Introduction to algorithms

---
<details>
<summary>
<b>Nearest null</b>
</summary>

<a href="NearestNull.java">Code</a>

Timofey is looking for a place to build his house. The street where he wants to live has a length of n, meaning it consists of n identical consecutive plots. Each plot is either empty or already has a house built on it.

Sociable Timofey doesn't want to live far from other people on this street. Therefore, it is important for him to know the distance to the nearest empty plot for each plot. If the plot is empty, this distance will be zero – the distance to itself.

Help Timofey calculate the desired distances. You have a map of the street. The houses in Timofey's city were numbered in the order they were built, so their numbers on the map are not ordered in any way. Empty plots are marked with zeros.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            5
            <br>
            0 1 4 9 0
        </td>
        <td>
            -183
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

In the first line, the length of the street is given — n (1 ≤ n ≤ 106). The next line contains n integers, non-negative numbers representing the house numbers and indications of empty plots on the map (zeros). It is guaranteed that there is at least one zero in the sequence. The house numbers (positive numbers) are unique and do not exceed 10^9.

<b>Output format</b>

For each of the plots, output the distance to the nearest zero. Output the distances in a single line, separating them by spaces.
</details>

<details>
<summary>
<b>Sleight of hand</b>
</summary>

<a href="NearestNull.java">Code</a>

The game "Typing Speed Trainer" is a 4x4 grid of keys, each key containing either a dot or a digit from one to nine. The essence of the game is as follows: in each round, a combination of digits and dots appears on the field. At time t, the player must simultaneously press all the keys with the digit t.

If all the necessary keys are pressed at time t, the players earn one point. If there are no keys with the digit t on the field at time t, no winning point is awarded.

At any given moment, two players can press k keys each. Find the number of points that Gosha and Timofey can earn if they press the keys together. Let's consider an example where k=3.

Suppose t=1. In this case, one player must press two keys with the digit 1. To determine how many keys two players will press, we can use the formula: k*2. It turns out that the boys together will press six keys and earn a winning point.

When t=2, the two players need to press seven keys simultaneously. But this is beyond their capability: each can only press three keys. No winning point is awarded.

At t=3, each player needs to press one key. Success! Now Gosha and Timofey have a total of two winning points.

There are no other digits on the field. Therefore, in the next rounds where t=4...t=9, no winning points will be awarded. Thus, Gosha and Timofey will earn two points.

Find the number of points that Gosha and Timofey can earn if they press the keys together.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            3
            <br>
            1231
            <br>
            2..2
            <br>
            2..2
            <br>
            2..2
            <br>
        </td>
        <td>
            2
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке дано целое число k (1 ≤ k ≤ 5).

In the first line, an integer k is given (1 ≤ k ≤ 5).

The next four lines describe the configuration of the typing trainer, with 4 characters in each line. Each character is either a dot or a digit from 1 to 9. The symbols in each line are consecutive and not separated by spaces.

<b>Output format</b>

Output a single number - the maximum number of points that Gosha and Timofey can score.

</details>

## 2. Main data structures

---
<details>
<summary>
<b>Deque</b>
</summary>

<a href="Deque.java">Code</a>

Gosha implemented a data structure, a deque, with a maximum size determined by a given number. The methods push_back(x), push_front(x), pop_back(), and pop_front() were working correctly. However, when there were many elements in the deque, the program ran very slowly. The issue was that not all operations were executed in O(1) time. Help Gosha! Write an efficient implementation.

Note: Use a circular buffer in your implementation.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            4
            <br>
            4
            <br>
            push_front 861
            <br>
            push_front -819
            <br>
            pop_back
            <br>
            pop_back
        </td>
        <td>
            861
            <br>
            -819
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

The first line contains the number of commands, n — an integer not exceeding 100,000. The second line contains the number m — the maximum size of the deque, not exceeding 50,000. The following n lines contain one of the commands:

- push_back(value) – add an element to the end of the deque. If the deque already contains the maximum number of elements, output "error."
- push_front(value) – add an element to the beginning of the deque. If the deque already contains the maximum number of elements, output "error."
- pop_front() – output the first element of the deque and remove it. If the deque was empty, output "error."
- pop_back() – output the last element of the deque and remove it. If the deque was empty, output "error."

Value — an integer not exceeding 1000 in absolute value.

<b>Output format</b>

Output the result of each command on a separate line. For successful push_back(x) and push_front(x) commands, nothing needs to be printed.

<b> Work principle </b>

Использую кольцевой буфер, как и было указано в условии. Реализованы методы
pop_front, pop_back(), push_front(int number) и push_back(int number).



<b> The proof of correctness </b>


For operations involving adding to the tail and removing from the head, we move clockwise. Therefore, the index is calculated as the remainder of division by the maximum. For operations involving adding to the head and removing from the tail, we move counterclockwise. Therefore, the index is calculated as n - 1, except when n = 0, as Java does not handle negative indices like Python.



<b> Time complexity </b>

Since I am using a regular array for adding elements, knowing the index will make the operations of adding and removing from it O(1). The overall complexity is O(n), where n is the number of commands given.

<b> Space complexity </b>

We store an array of n numbers in memory, along with the start and end indices, size, and maximum number of elements. The complexity is O(n).

</details>

<details>
<summary>
<b>Calculator</b>
</summary>

<a href="Calculator.java">Code</a>

The task is related to Reverse Polish Notation (RPN), also known as postfix notation. It is used for parsing arithmetic expressions. In postfix notation, operands are placed before the operation signs. Note regarding negative numbers and division: in this task, division refers to mathematical integer division. This means that rounding always occurs downwards. Specifically, if a / b = c, then b ⋅ c is the largest number that does not exceed a and simultaneously is divisible by b without a remainder. In this task, it is guaranteed that there is no division by a negative number.

Example 1: 3 4 + means 3 + 4 and equals 7.

Example 2: 12 5 / Since division is integer, the result will be 2.

Example 3: 10 2 4 * - means 10 - 2 * 4 and equals 2.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            2 1 + 3 *
        </td>
        <td>
            9
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

In the single line, an expression is given written in Reverse Polish Notation. Numbers and arithmetic operations are separated by spaces. The input may contain the operations: +, -, *, /, and numbers not exceeding 10 000 in absolute value. It is guaranteed that the value of intermediate expressions in the test data does not exceed 50 000 in absolute value.

<b>Output format</b>

Output a single number — the value of the expression.

<b> Work principle </b>


The task is implemented using a stack, which is needed to maintain the sequence of numbers. We check each element of the array passed to the `polishNotation` function. If it is a mathematical operation sign, we extract two elements from the stack, perform the required operation, and then save the result in the stack. Otherwise, we simply save the new number in the stack. In the end, there should be only one number left in the stack — the result of all operations.


<b> The proof of correctness </b>

As indicated by the condition, operands are placed before operation signs. Therefore, we need to use the Last In, First Out (LIFO) principle to satisfy this condition. A stack follows this principle. For multiplication and addition, the sequence of elements does not matter, so we do not need to save the second operand separately for their calculation. However, for division and subtraction, we need to maintain the order.




<b> Time complexity </b>

Adding to the stack has a time complexity of O(1). In the method, we iterate through all elements only once, so the overall complexity will be O(n), where n is the number of elements provided as input.

<b> Space complexity </b>

Since we only save numbers once, the stack will contain a maximum of n elements. The space complexity is O(n), where n is the number of elements provided as input.

</details>

## 3. Sorts and recursion

---
<details>
<summary>
<b>BrokenSearch</b>
</summary>

<a href="BrokenSearch.java">Code</a>

Alla made a mistake while copying from one data structure to another. She stored an array of numbers in a circular buffer. The array was sorted in ascending order, and an element could be found in it in logarithmic time. Alla copied the data from the circular buffer to a regular array but shifted the data of the original sorted sequence (while the array could still remain sorted). Nevertheless, it is necessary to provide the ability to find an element in it in O(log n) time. It can be assumed that the array contains only unique elements. You are required to implement a function that performs a search in the broken array. Please note that reading data and outputting the answer is not required.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            9
            <br>5
            <br>19 21 100 101 1 4 5 7 12
            <br>
            <br>
            2
            <br>
            1
            <br>
            5 1
            <br>
        </td>
        <td>
            <br>
            <br>
            1
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

The function takes an array of natural numbers and a target number k. The length of the array does not exceed 10,000. The elements of the array and the number k do not exceed 10,000 in value. In the examples: The first line contains the number n — the length of the array. The second line contains a positive number k — the target element. Then, in a single line, n natural numbers are written, separated by a space — the elements of the array.

<b>Output format</b>

The function should return the index of the element equal to k if such an element exists in the array (indexing starts from zero). If the element is not found, the function should return -1. It is not allowed to modify the array. To filter out inefficient solutions, your function will be executed between 100,000 and 1,000,000 times.

<b> Work principle </b>


The problem is implemented using a stack, which is necessary for maintaining the sequence of numbers. We check each element from the array passed to the `polishNotation` function. If it is a mathematical operation sign, we pop two elements from the stack, perform the required operation, and then save the result in the stack. Otherwise, we simply save the new number in the stack. In the end, there should be only one number left in the stack—the result of all operations.


<b> The proof of correctness </b>

If we look at the last element of the array, we can determine in which part the target element is located. Both parts are sorted according to the task condition. If the target number x is less than the end of the array, then if it exists, it is in the range from the beginning of the sorted part to the end of the array. If it is greater, then it is in the range from the beginning of the array to the beginning of the sorted part.




<b> Time complexity </b>

We know that the time complexity of binary search is O(log n). In the worst case, we may need to first traverse the entire array to find the beginning of the sorted part. If it turns out that the array is fully sorted (the beginning is at index 0), then we will need to traverse the entire array again. Therefore, the time complexity will be 2 * O(log n) = O(log n), as constant values are not considered in the asymptotic notation.

<b> Space complexity </b>


We store an array of n numbers in memory, along with the index of the beginning of the sorted part. The space complexity is O(n) for the array and O(log n) * 2 for the necessary memory for the recursion calls (calculated based on its depth).


</details>

<details>
<summary>
<b>EfficientQuickSort</b>
</summary>

<a href="EfficientQuickSort.java">Code</a>

Timofey decided to organize a programming competition to find talented interns. Problems have been selected, participants are registered, and tests are written. The remaining task is to determine how the winner will be determined at the end of the competition. Each participant has a unique login. When the competition is over, two indicators will be associated with each participant: the number of solved problems Pi and the penalty size Fi. The penalty is charged for unsuccessful attempts and the time spent on the problem.

Timofey decided to sort the results table as follows: when comparing two participants, the one with more solved problems will be ranked higher. In case of a tie in the number of solved problems, the participant with a smaller penalty comes first. If the penalties are also equal, the one with the login that comes earlier in alphabetical (lexicographical) order takes precedence.

Timofey ordered sweatshirts for the winners and went to the store the day before. In his absence, he entrusted you to implement the quicksort algorithm for the results table. Since Timofey loves competitive programming and dislikes wasting memory, your sorting implementation cannot consume O(n) additional memory for intermediate data (this modification of quicksort is called "in-place").

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
           5<br>
            alla 4 100<br>
            gena 6 1000<br>
            gosha 2 90<br>
            rita 2 90<br>
            timofey 4 80
        </td>
        <td>
            gena<br>
            timofey<br>
            alla<br>
            gosha<br>
            rita<br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

The first line specifies the number of participants, n, where 1 ≤ n ≤ 100,000. Each of the next n lines contains information about one participant. The i-th participant is described by three parameters:

1. A unique login (a string of lowercase Latin letters with a length of at most 20).
2. The number of solved problems, Pi.
3. The penalty size, Fi.

Fi and Pi are integers ranging from 0 to 10^9.

<b>Output format</b>

For the sorted list of participants, output their logins one per line in the specified order.


<b> Work principle </b>


For the user, I created an additional class called User, which has three fields (name, number of solved problems, and penalty). Inside the class, I implemented a comparison method that returns a positive number if the user is greater and a negative number if the user is smaller. Within the sorting method, I iterate with two cursors from the beginning and the end of the array's sortable part. I move from left to right those users who are smaller than the pivot and from right to left those who are larger than the pivot. Recursively, I sort the right and left parts.



<b> The proof of correctness </b>

On each pass, the pivot element takes its correct position, as its final index will be equal to the number of elements to its right.




<b> Time complexity </b>

The worst-case time complexity will be O(n^2) if the pivot is consistently smaller or larger than all other parts. In practice, it is more likely to run in O(n log n) time, as the recursion depth is O(log n), and at each recursion step, there are O(n) operations.


<b> Space complexity </b>

We store an array of numbers 'n', the index of the beginning, and the end of the sortable parts in memory. The complexity is O(n) (as we modify the original array each time) + O(log n) for the stack space according to the recursion depth.


</details>

## 4. Hash functions

---
<details>
<summary>
<b>SearchSystem</b>
</summary>

<a href="SearchSystem.java">Code</a>

Timofey is developing his own search engine.

There are n documents, each representing text composed of words. A search index needs to be built based on these documents. The system will receive queries as input. The query is a set of words, and the goal is to output the 5 most relevant documents. The relevance of a document is evaluated as follows: for each unique word in the query, the number of occurrences of that word in the document is taken, and the numbers obtained for all words in the query are summed. The final sum is considered the relevance of the document. The higher the sum, the more the document fits the query. The sorting of documents in the output is done in descending order of relevance. If the relevance of documents is the same, they are sorted in ascending order of their ordinal numbers in the database (i.e., in the input data). Consider cases where queries consist of words that occur in a small number of documents. What if one word occurs many times in one document?

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            3<br>
            i love coffee<br>
            coffee with milk and sugar<br>
            free tea for everyone<br>
            3<br>
            i like black coffee without milk<br>
            everyone loves new year<br>
            mary likes black coffee without milk<br>
        </td>
        <td>
            1 2<br>
            3<br>
            2 1<br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

In the first line, a natural number n is given, representing the number of documents in the database (1 ≤ n ≤ 10^4).

Then, in the next n lines, the documents are provided, one per line. Each document consists of multiple words separated by a single space and consists of lowercase Latin letters. The length of one text does not exceed 1000 characters. The text is never empty.

The next line contains the number of queries, m, as a natural number (1 ≤ m ≤ 10^4). In the following m lines, the queries are given, one per line. Each query consists of one or several words. The query is not empty. Words are separated by a single space and consist of lowercase Latin letters. The number of characters in a query does not exceed 100.

<b>Output format</b>

For each query, output on one line the numbers of the five most relevant documents. If fewer than five documents are found, output as many as were found. Do not output documents with a relevance of 0.

<b> Work principle </b>


That's a reasonable approach. It seems like you're creating a mapping structure to efficiently retrieve and compute relevance scores for each word in each document. Then, for each query, you're calculating the relevance scores based on the occurrences of unique words in the query and sorting the documents based on these scores.

Remember that this approach assumes that the relevance of a document to a query is solely based on the sum of occurrences of words. Depending on your use case, you might want to consider more advanced techniques, such as TF-IDF (Term Frequency-Inverse Document Frequency) or machine learning models, to improve the accuracy of your search engine.



<b> The proof of correctness </b>

Since, during the reading of all the documents, we prepared an intermediate map with the occurrences of each word, we don't need to look at the documents each time and recount the occurrences. This speeds up the search.





<b> Time complexity </b>

First, we iterate over all documents (n), then for each search query (number of search queries - m), we iterate over its unique words. The operations of retrieving and entering into the map are O(1). In the worst case, all unique words will be contained in all documents (n). After that, we search for the maximum values in the documents that contain at least part of the query, in the worst case, they will be contained in all documents (n). So, it becomes O(n + nm + 5n) -> O(6n + nm) -> O(n + nm).

<b> Space complexity </b>

The complexity of the solution is O(n + m), where n is the number of unique words in all documents, and m is the number of documents, as in the worst case, at least one sought-after word will be in all documents. <br>

</details>

<details>
<summary>
<b>HashTable</b>
</summary>

<a href="HashTable.java">Code</a>

Timofey, being a good manager, keeps information about his employees' salaries in a database and updates it regularly. He assigned you to write an implementation of a hash table to store the database with employees' salaries.

The hash table should support the following operations:

- put key value –– adding a key-value pair. If the given key already exists in the table, the corresponding value is updated.
- get key –— retrieving the value by key. If the key is not in the table, output "None". Otherwise, output the found value.
- delete key –— removing a key from the table. If there is no such key, output "None". Otherwise, output the stored value for the given key and delete the key.

The table stores unique keys.

Implementation requirements:

- Do not use existing implementations of hash tables in programming languages (std::unordered_map in C++, dict in Python, HashMap in Java, etc.).
- Resolve collisions using either the chaining method or open addressing.
- All operations should be performed in O(1) on average.
- Supporting rehashing and scaling of the hash table is not required.
- Keys and values, employee IDs, and their salaries are integers. There is no need to support arbitrary hashable types.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            8<br>
            get 9<br>
            delete 9<br>
            put 9 1<br>
            get 9<br>
            put 9 2<br>
            get 9<br>
            put 9 3<br>
            get 9<br>
        </td>
        <td>
            None<br>
            None<br>
            1<br>
            2<br>
            3<br>
            <br>
            <br>
            <br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

The first line contains the total number of queries to the table, \( n \) (\( 1 \leq n \leq 10^6 \)). The following \( n \) lines contain queries, which can be of three types: get, put, delete, as described in the task.

All keys and values are integers, not exceeding \( 10^9 \) in absolute value. Numbers can be negative as well.

For any sequence of commands, the number of keys in the hash table cannot exceed \( 10^5 \).

<b>Output format</b>

На каждый запрос вида get и delete выведите ответ на него в отдельной строке.


<b> Work principle </b>


Написала мапу с разрешением коллизий методом цепочек. Если нужно добавить значение,
сначала проверяю, нет ли в списке уже такого ключа. Если есть, записываю для него новое значение.
Если нет, создаю новую ноду и сохраняю ее в качестве головы связного списка.
Для того, чтобы получить значение, высчитываю номер бакета и ищу нужный ключ по всему связному списку
в этом бакете. Если ключ находится, возвращаю связанное с ним значение. Если нет, то возвращаю None.
Для операции удаления ищу нужный ключ. Если нода была в начале списка, то сохраняю новое начало в бакете.
Если в середине, то вырезаю ноду, сохраняя в предыдущей ноде ссылку на последующую.



<b> The proof of correctness </b>

Для того, чтобы значения распределялись более равномерно, размер массива - это 2 в степени 16.
Номер бакета определяется с помощью побитового И.




<b> Time complexity </b>

Все ноды хранятся в массиве. Скорость чтения и добавления элемента в массив - O(1). При хорошей
распределенности поиск, удаление и добавление будут стоить O(1). Значит, для n команд сложность будет
O(n).


<b> Space complexity </b>

В худшем случае все команды будут на добавление данных в массив, и сложность будет O(n), где n - количество команд.



</details>

## 5. Trees

---

<details>
<summary>
<b>HeapSort</b>
</summary>

<a href="HeapSort.java">Code</a>

В данной задаче необходимо реализовать сортировку кучей. При этом кучу необходимо реализовать самостоятельно, использовать имеющиеся в языке реализации нельзя. Сначала рекомендуется решить задачи про просеивание вниз и вверх.

Тимофей решил организовать соревнование по спортивному программированию, чтобы найти талантливых стажёров. Задачи подобраны, участники зарегистрированы, тесты написаны. Осталось придумать, как в конце соревнования будет определяться победитель.

Каждый участник имеет уникальный логин. Когда соревнование закончится, к нему будут привязаны два показателя: количество решённых задач Pi и размер штрафа Fi. Штраф начисляется за неудачные попытки и время, затраченное на задачу.

Тимофей решил сортировать таблицу результатов следующим образом: при сравнении двух участников выше будет идти тот, у которого решено больше задач. При равенстве числа решённых задач первым идёт участник с меньшим штрафом. Если же и штрафы совпадают, то первым будет тот, у которого логин идёт раньше в алфавитном (лексикографическом) порядке.

Тимофей заказал толстовки для победителей и накануне поехал за ними в магазин. В своё отсутствие он поручил вам реализовать алгоритм сортировки кучей (англ. Heapsort) для таблицы результатов.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            5<br>
            alla 4 100<br>
            gena 6 1000<br>
            gosha 2 90<br>
            rita 2 90<br>
            timofey 4 80<br>
        </td>
        <td>
            gena<br>
            timofey<br>
            alla<br>
            gosha<br>
            rita<br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке задано число участников n, 1 ≤ n ≤ 100 000.
В каждой из следующих n строк задана информация про одного из участников.
i-й участник описывается тремя параметрами:
<ul>
<li>уникальным логином (строкой из маленьких латинских букв длиной не более 20)</li>
<li>числом решённых задач Pi</li>
<li>штрафом Fi</li>
</ul>
Fi и Pi — целые числа, лежащие в диапазоне от 0 до 109.

<b>Output format</b>

Для отсортированного списка участников выведите по порядку их логины по одному в строке.


<b> Work principle </b>


Пирамидальная сортировка реализуется с помощью бинарной кучи. Сначала добавляем все элементы в дерево
с помощью просеивания вверх (меняем дочерный узел и родительский местами, если дочерний элемент больше родительского). Затем удаляем корень каждый раз (это первый элемент), заменяем на последний элемент и
просеиваем вниз (меняем родительский узел и дочерний местами, если родительский меньше дочернего), пока не знакончатся элементы. Для сравнения элементов написан метод compareTo.



<b> The proof of correctness </b>

Свойства невозврастающей кучи таковы, что в корне будет всегда находиться самый большой элемент. Каждый раз,
когда мы его выводим и удаляем, проводится просеивание вниз, которое восстанавливает свойство кучи.





<b> Time complexity </b>

Для каждого элемента мы делаем два действия: вставляем и просеиваем вверх, удаляем и просеиваем вниз. Просеивание
стоит O(log n), так как на каждом уровне мы проводим только одно сравнение элемента.
Временная сложность: O(n * 2 log n) -> O(n log n)


<b> Space complexity </b>

Требуется массив для хранения дерева, который содержит n элементов для сортировки. Пространственная сложность - O(n).


</details>

<details>
<summary>
<b>RemoveNode</b>
</summary>

<a href="RemoveNode.java">Code</a>

Дано бинарное дерево поиска, в котором хранятся ключи. Ключи — уникальные целые числа. Найдите вершину с заданным ключом и удалите её из дерева так, чтобы дерево осталось корректным бинарным деревом поиска. Если ключа в дереве нет, то изменять дерево не надо.
На вход вашей функции подаётся корень дерева и ключ, который надо удалить. Функция должна вернуть корень изменённого дерева. Сложность удаления узла должна составлять O(h), где h –— высота дерева.
Создавать новые вершины (вдруг очень захочется) нельзя.


<b>Input format</b>

Ключи дерева – натуральные числа, не превышающие 10^9. В итоговом решении не надо определять свою структуру/свой класс, описывающий вершину дерева.



<b> Work principle </b>


Сначала проверяю, есть ли вообще дерево. Потом ищу элемент, который нужно заменить, и его родительскую ноду.
Если элемента нет, ничего не делаю, возвращаю корень.  
Если элемент есть, проверяю, можно ли найти элемент на замену. Если есть левая часть, ищу там самый правый элемент.
Если нет левой части, но есть правая часть, ищу самый левый элемент в ней. Для элементов на замену есть два кейса -
когда между элементом на замену и элементом на удаление есть как минимум одна вершина, и когда элемент на замену
идет сразу после вершины. В зависимости от этого выставляю в элементе на замену новых потомков.
Если нет ни левой, ни правой части, элемент на замену остается null.  
Если у элемента на замену нет родителя, значит удаляем корень и возвращаем элемент на замену.
Если родитель есть, ставим в качестве нужного нам потомка элемент на замену.


<b> The proof of correctness </b>

Чтобы удалить элемент и сохранить структуру дерева, нужно на его место поставить элемент, который будет корректно разделать
два оставшихся поддерева. Это должен быть самый большой элемент из левой части или самый маленький из правой.




<b> Time complexity </b>

Сначала ищем нужный элемент за O(H) в худшем случае, где H - это высота дерева. Если это O(H), тогда это лист, у которого нет потомков, и элемент на замену
будет null, а значит сложность не изменится.
Если элемент в середине, тогда ищем его за O(H - n), высота поддерева. Затем ищем элемент на замену за O(n).  
В итоге O(H - n + n) -> O(H).

<b> Space complexity </b>

Сохраняем отдельно элемент на удаление и его родительский элемент, а также элемент на замену и его родительский элемент.  
Сложность O(4) -> O(1).


</details>

## 6. Graphs

---

<details>
<summary>
<b>ExpensiveNet</b>
</summary>

<a href="ExpensiveNet.java">Code</a>

Тимофей решил соединить все компьютеры в своей компании в единую сеть. Для этого он придумал построить минимальное остовное дерево, чтобы эффективнее использовать ресурсы.

Но от начальства пришла новость о том, что выделенный на сеть бюджет оказался очень большим и его срочно надо израсходовать. Поэтому Тимофея теперь интересуют не минимальные, а максимальные остовные деревья.

Он поручил вам найти вес такого максимального остовного дерева в неориентированном графе, который задаёт схему офиса.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            4 4<br>
            1 2 5<br>
            1 3 6<br>
            2 4 8<br>
            3 4 3<br>
        </td>
        <td>
            19<br>
            <br>
            <br>
            <br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке дано количество вершин n и ребер m графа (1 ≤ n ≤ 1000, 0 ≤ m ≤ 100000).

В каждой из следующих m строк заданы рёбра в виде троек чисел u, v, w. u и v — вершины, которые соединяет это ребро. w — его вес ( 1 ≤ u, v ≤ n, 0 ≤ w ≤ 10000). В графе могут быть петли и кратные ребра. Граф может оказаться несвязным.

<b>Output format</b>

Если максимальное остовное дерево существует, то выведите его вес. Иначе (если в графе несколько компонент связности) выведите фразу «Oops! I did it again».

<b> Work principle </b>


Чтобы построить остовное дерево, я использовала алгоритм Прима. Есть set вершин, которые уже есть в остове и set для тех, которые еще не добавлены.
Также создана мапа с ребрами и их весом. Когда я добавляю вершину в added, я также добавляю все ее ребра в мапу.
Потом из этой мапы ищу самое большое значение для тех вершин, которых еще нет в added.
И так до тех пор, пока не закончатся ребра или не закончатся вершины. Если вершины еще не закончились, а ребра уже да,
значит в графе несколько компонент связности.



<b> The proof of correctness </b>

Так как мы сохраняем и посещенные, и непосещенные вершины, мы можем отследить, записали ли мы в остов все вершины по
одному разу.




<b> Time complexity </b>

Сложность алгоритма O(log(V) * E), так как используется очередь с приоритетом, для которой вставка и удаление элемента
происходят за O(logV). V - количество вершин, E — количество ребер в графе.


<b> Space complexity </b>

Есть матрица для хранения графа(V*V), приоритетная очередь для хранения ребер(E) и массив для хранения информации о
добавленных вершинах (V). Следовательно, пространственная сложность — O(V^2 + E + V) -> O(V^2 + E), где V - количество вершин,

E — количество ребер в графе.



</details>

<details>
<summary>
<b>Railways</b>
</summary>

<a href="Railways.java">Code</a>

В стране X есть n городов, которым присвоены номера от 1 до n. Столица страны имеет номер n. Между городами проложены железные дороги.

Однако дороги могут быть двух типов по ширине полотна. Любой поезд может ездить только по одному типу полотна. Условно один тип дорог помечают как R, а другой как B. То есть если маршрут от одного города до другого имеет как дороги типа R, так и дороги типа B, то ни один поезд не сможет по этому маршруту проехать. От одного города до другого можно проехать только по маршруту, состоящему исключительно из дорог типа R или только из дорог типа B.

Но это ещё не всё. По дорогам страны X можно двигаться только от города с меньшим номером к городу с большим номером. Это объясняет большой приток жителей в столицу, у которой номер n.

Карта железных дорог называется оптимальной, если не существует пары городов A и B такой, что от A до B можно добраться как по дорогам типа R, так и по дорогам типа B. Иными словами, для любой пары городов верно, что от города с меньшим номером до города с бОльшим номером можно добраться по дорогам только какого-то одного типа или же что маршрут построить вообще нельзя. Выясните, является ли данная вам карта оптимальной.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            3<br>
            RB<br>
            R<br>
        </td>
        <td>
            NO<br>
            <br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке дано число n (1 ≤ n ≤ 5000) — количество городов в стране. Далее задана карта железных дорог в следующем формате.

Карта задана n-1 строкой. В i-й строке описаны дороги из города i в города i+1, i+2, ..., n. В строке записано n - i символов, каждый из которых либо R, либо B. Если j-й символ строки i равен «B», то из города i в город i + j идет дорога типа «B». Аналогично для типа «R».

<b>Output format</b>

Выведите «YES», если карта оптимальна, и «NO» в противном случае.

<b> Work principle </b>


Поиск циклов осуществляется с помощью DFS — если при проверке вершин какая-то из них оказывается серой, то есть с ней еще не завершена работа, значит в графе есть цикл.



<b> The proof of correctness </b>

Мы знаем, что дан направленный граф, где все ребра направлены в одну сторону от города с меньшим номером к большему.
Так как у нас есть два вида дорог, чтобы различать их, можно тип 'B' развернуть от последей вершины к первой. Так R-дороги
будут направлены от меньшего города к большему, а B-дороги — от большего к меньшему.
Если это сделать, в тех графах, в которых к хотя бы одной из вершин есть 2 пути, появятся циклы.





<b> Time complexity </b>

Так как граф хранится в виде списков смежности, сложность DFS будет O(V + E), где V - количество вершин, E — количество ребер в графе.

<b> Space complexity </b>

Для того, чтобы реализовать DFS без рекурсии, требуется стек, который будет в какой-то момент содержать все вершины графа.
Также мы храним сам граф в виде списка списков.
Следовательно, пространственная сложность будет O(V + E), где V - количество вершин, E — количество ребер в графе.



</details>

## 7. Greedy Algorithms and Dynamic Programming

---

<details>
<summary>
<b>LevenshteinDistance</b>
</summary>

<a href="LevenshteinDistance.java">Code</a>

Расстоянием Левенштейна между двумя строками s и t называется количество атомарных изменений, с помощью которых можно одну строку превратить в другую. Под атомарными изменениями подразумеваются: удаление одного символа, вставка одного символа, замена одного символа на другой.

Найдите расстояние Левенштейна для предложенной пары строк.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            abacaba<br>
            abaabc<br>
        </td>
        <td>
            2<br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке дана строка s, во второй — строка t. Длины обеих строк не превосходят 1000. Строки состоят из маленьких латинских букв.

<b>Output format</b>

Выведите единственное число — расстояние между строками.

<b> Work principle </b>


Нам нужна двумерная матрица, но, так как подсчеты ведутся по последнему ряду, будем хранить только его.<br>
Базовый случай — dp[j] = j. Заполняем так первый ряд. Далее нулевой элемент будет равен i -> порядковому номеру цикла.<br>
Переход динамики — сравниваем значения currentDp[j-1] + 1, dp[j] + 1 и dp[j-1] + 1 (если буквы не равны) / dp[j-1] (если равны).<br>
Выбираем самое минимальное число.<br>
Ответ на исходный вопрос будет содержаться в ячейке dp [длина второго слова].


<b> The proof of correctness </b>

Первая строка, dp[j] = j -> чтобы получить строку из пустой, нужно провести j операций вставки
Первый символ последующих строк dp[0] = i -> чтобы получить пустую строку из текущей, нужно провести i операций удаления.

Если обе строки не пустые:
- если символы равны, значит мы не меняли последний символ, то есть выполнили D(i - 1, j - 1) операций
- если не равны, то последний символ меняли один раз, значит D(i - 1, j - 1) + 1.


<b> Time complexity </b>

Для вычисления используем цикл в цикле по размеру каждой из исследуемых строк (n и m). Сложность O(n * m).

<b> Space complexity </b>

Требуется дополнительный массив dp, длина которого равна длине одной из рассматриваемых строк (n). Также храним
в памяти временный массив для заполнения нового ряда (n) и сами строки (n и m). Сложность O(3n + m) -> O(n + m).


</details>

<details>
<summary>
<b>SameSums</b>
</summary>

<a href="SameSums.java">Code</a>

На Алгосах устроили турнир по настольному теннису. Гоша выиграл n партий, получив при этом некоторое количество очков за каждую из них.<br>
Гоше стало интересно, можно ли разбить все заработанные им во время турнира очки на две части так, чтобы сумма в них была одинаковой.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            4<br>
            1 5 7 1<br>
        </td>
        <td>
            True<br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке записано целое число n (0 ≤ n ≤ 300) –— количество выигранных партий.

Во второй строке через пробел записано n целых неотрицательных чисел, каждое из которых не превосходит 300 –— заработанные в партиях очки.

<b>Output format</b>

Нужно вывести True, если произвести такое разбиение возможно, иначе —– False

<b> Work principle </b>


В массиве dp хранится информация о том, можно или нет составить из элементов массива numbers число, равное индексу
текущего элемента i. Массив dp содержит количество значений, равное половине суммы всех чисел массива numbers(median) + 1.<br>
Базовый случай — dp[0] = true.<br>
Переход динамики — для каждого элемента из numbers проходим по dp. Если элемент dp[i] = true, прибавляем текущий элемент
из numbers к i.<br>
Ответ на исходный вопрос будет содержаться в ячейке dp[median].



<b> The proof of correctness </b>

Если элемент dp[i] = true, значит из чисел можно составить сумму i без учета текущего числа. Добавляем к i текущее число,
если не выходит за границы массива, отмечаем в dp. В итоге после прохождения по всем числам dp[median] = true, значит,
нужную нам сумму составить возможно.





<b> Time complexity </b>

Для вычисления проходимся для всех чисел (n) по массиву dp (m). Временная сложность O(n * m).

<b> Space complexity </b>

Храним все числа (n), также требуется массив dp для хранения результатов промежуточных вычислений (m).
Пространственная сложность O(n + m).

</details>

## 8. Algorithms on strings

---

<details>
<summary>
<b>PackedPrefix</b>
</summary>

<a href="PackedPrefix.java">Code</a>

Вам даны строки в запакованном виде. Определим запакованную строку (ЗС) рекурсивно. Строка, состоящая только из строчных букв английского алфавита является ЗС. Если A и B —– корректные ЗС, то и AB является ЗС. Если A —– ЗС, а n — однозначное натуральное число, то n[A] тоже ЗС. При этом запись n[A] означает, что при распаковке строка A записывается подряд n раз. Найдите наибольший общий префикс распакованных строк и выведите его (в распакованном виде).

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            3<br>
            2[a]2[ab]<br>
            3[a]2[r2[t]]<br>
            a2[aa3[b]]<br>
        </td>
        <td>
            aaa<br>
            <br>
            <br>
            <br>
</td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке записано число n (1 ≤ n ≤ 1000) –— число строк.

Далее в n строках записаны запакованные строки. Гарантируется, что эти строки корректны, то есть удовлетворяют указанному рекурсивному определению. Длина строк после распаковки не превосходит 10^5.

<b>Output format</b>

Выведите наибольший общий префикс распакованных строк.


<b> Work principle </b>


Чтобы распаковать строку, использую стек со списком чаров и стек с числами - количеством повторений.<br>
Прохожусь по каждому символу в строке. Если это число, тогда добавляю в стек символов<br>
новый список, а в стек чисел - это число. Если это символ, проверяю, есть ли в стеке элементы. Если он пустой,
это значит, что текущий символ повторять не требуется, можно добавить его к финальному результату.<br>
Если есть элементы, значит их нужно будет повторить, добавляю элемент к верхнему списку в стеке.<br>
Если символ - закрывающая кавычка, то это значит, что нужно вытащить верхний список из стека и добавить
к результирующей строке, повторив n раз.<br>

Для определения общего префикса использую простой цикл по количеству символов в самой маленькой строке и счетчик. Если все символы равны, смотрим следующий. Если нет, то цикл разрывается, и выводится текущее значение счетчика.


<b> The proof of correctness </b>

Для того, чтобы корректно распаковать строку, нам нужно использовать принцип LIFO, именно он и лежит в основе стека.




<b> Time complexity </b>

Для распаковки строки используем цикл по всем символам строки n.<br>
Для поиска префикса - цикл по всем символам самой меньшей строки, которая будет также равна n.<br>
Таким образом, временная сложность будет O(2n * x) -> O(n * x), где x - количество строк для сравнения, n - среднее количество символов в строке.

<b> Space complexity </b>

Требуется стек чисел и стек символов, общее количество символов в которых будет n. Также мы храним результирующую строку в формате StringBuilder и список всех готовых строк для поиска префикса.<br>
Пространственная сложность - O(x * n), где x - количество строк для сравнения, n - среднее количество символов в строке.


</details>

<details>
<summary>
<b>Crib</b>
</summary>

<a href="Crib.java">Code</a>

Вася готовится к экзамену по алгоритмам и на всякий случай пишет шпаргалки.

Чтобы уместить на них как можно больше информации, он не разделяет слова пробелами. В итоге получается одна очень длинная строка. Чтобы на самом экзамене из-за нервов не запутаться в прочитанном, он просит вас написать программу, которая по этой длинной строке и набору допустимых слов определит, можно ли разбить текст на отдельные слова из набора.

Более формально: дан текст T и набор строк s1, ... ,sn. Надо определить, представим ли T как sk1sk2...skr, где где ki — индексы строк. Индексы могут повторяться. Строка si может встречаться в разбиении текста T произвольное число раз. Можно использовать не все строки для разбиения. Строки могут идти в любом порядке.

<table>
    <tbody>
      <tr>
        <td><b>Input</b></td>
        <td><b>Output</b></td>
      </tr>
      <tr>
        <td>
            examiwillpasstheexam<br>
            5<br>
            will<br>
            pass<br>
            the<br>
            exam<br>
            i<br>
        </td>
        <td>
            YES<br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </td>
      </tr>
    </tbody>
</table>

<b>Input format</b>

В первой строке дан текст T, который надо разбить на слова. Длина T не превосходит 100100. Текст состоит из строчных букв английского алфавита.

Во второй строке записано число допустимых к использованию слов 1 ≤ n ≤ 100.

В последующих n строках даны сами слова, состоящие из маленьких латинских букв. Длина каждого слова не превосходит 100.

<b>Output format</b>

Выведите «YES», если текст можно разбить на слова из данного словаря, или «NO» в ином случае.

<b> Work principle </b>


Строим префиксное дерево. Затем, используя его, проходимся по заданному набору символов с помощью динамического программирования.<br>
В массиве dp будет храниться значение boolean, которое обозначает, является ли текущий символ потенциальным началом слова или нет.<br>
Проходимся по всем символам заданного набора в цикле. Если текущий символ является потенциальным началом слова, нам нужно найти начало следующего слова. Сначала устанавливаем в качестве текущей ноды дерева его корень.<br>
Дальше проходимся циклом, начиная от потенциального начала слова до конца массива.<br>
Если символ есть в словаре Children текущей ноды, проверяем, является ли этот символ концом слова. Если да, устанавливаем следующий символ как потенциальное начало слова в dp. Если символа нет, цикл разрывается.<br>
В итоге если из набора символов можно составить цепочку из указанных слов без разрывов, тогда последним элементом в массиве dp будет true.<br>


<b> The proof of correctness </b>

Мы используем префиксное дерево для экономии памяти. Если поле isWord равняется true, значит по указанному пути можно составить корректное слово.<br>
Пользуемся этим для того, чтобы найти все возможные варианты слов и индекс потенциального начала нового слова.




<b> Time complexity </b>

Составление префиксного дерева требует O(n), где n - общее количество символов во всех словах. Поиск потенциальных слов требует два цикла - первый
по всем символам заданной последовательности m, второй внутри первого по части последовательности. В худшем случае поиск всех потенциальных слов занимает O(n^2).

<b> Space complexity </b>

Требуется дополнительная память требуется для хранения исследуемой строки и всех потенциальных слов в виде дерева. Размер дерева - O(n * m), где n - максимальная длина слова, а m - количество букв в алфавите.



</details>
