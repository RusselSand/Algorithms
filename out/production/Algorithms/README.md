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

The first line contains the total number of queries to the table, n (1≤ n≤ 10^6). The following n  lines contain queries, which can be of three types: get, put, delete, as described in the task.

All keys and values are integers, not exceeding 10^9 in absolute value. Numbers can be negative as well.

For any sequence of commands, the number of keys in the hash table cannot exceed 10^5.

<b>Output format</b>

For each query of type get and delete, output the corresponding answer on a separate line.

<b> Work principle </b>


I implemented a map using the method of resolving collisions with chaining. When adding a value, I first check if there is already a key in the list. If it exists, I update its value. If not, I create a new node and store it as the head of the linked list.

To retrieve a value, I calculate the bucket number and search for the desired key throughout the linked list in that bucket. If the key is found, I return the associated value. If not, I return None.

For the delete operation, I search for the required key. If the node was at the beginning of the list, I save the new head in the bucket. If it's in the middle, I cut out the node, preserving the reference to the next one in the previous node.


<b> The proof of correctness </b>

To distribute values more evenly, the size of the array is chosen as 2 to the power of 16. The bucket number is determined using bitwise AND.




<b> Time complexity </b>

All nodes are stored in the array. The speed of reading and adding an element to the array is O(1). With good distribution, search, deletion, and addition will cost O(1). Therefore, for n commands, the complexity will be O(n).


<b> Space complexity </b>

In the worst case, all commands will involve adding data to the array, and the complexity will be O(n), where n is the number of commands.


</details>

## 5. Trees

---

<details>
<summary>
<b>HeapSort</b>
</summary>

<a href="HeapSort.java">Code</a>

In this task, you need to implement heap sort. The heap should also be implemented independently; using existing language implementations is not allowed. It is recommended to first solve problems related to heapify operations (sifting down and up).

Timotheus decided to organize a programming competition to find talented interns. The problems have been selected, participants have been registered, and tests have been written. Now it remains to figure out how to determine the winner at the end of the competition.

Each participant has a unique login. When the competition is over, two indicators will be associated with each participant: the number of solved problems \( P_i \) and the penalty size \( F_i \). The penalty is charged for unsuccessful attempts and the time spent on the problem.

Timotheus decided to sort the results table as follows: when comparing two participants, the one with more solved problems comes first. In case of a tie in the number of solved problems, the participant with a smaller penalty comes first. If the penalties are also equal, the one whose login comes first in alphabetical (lexicographic) order is placed first.

Timotheus ordered sweatshirts for the winners and went to the store the day before. In his absence, he entrusted you to implement the heapsort algorithm for the results table.

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

The first line contains the number of participants n, 1 ≤ n ≤ 100 000. In each of the next \( n \) lines, information about one participant is provided. The \( i \)-th participant is described by three parameters:

- A unique login (a string of lowercase Latin letters with a length of at most 20).
- The number of problems solved P_i.
- The penalty F_i.

Both F_i and P_i are integers in the range from 0 to 10^9.

<b>Output format</b>

For the sorted list of participants, output their logins one per line in the given order.

<b> Work principle </b>


Heap sort is implemented using a binary heap. Initially, all elements are added to the tree using sift-up (swapping child and parent if the child is greater than the parent). Then, the root is removed each time (which is the first element), replaced with the last element, and sifted down (swapping parent and child if the parent is smaller than the child) until there are no more elements. A compareTo method is written to compare elements.


<b> The proof of correctness </b>

The properties of a max heap are such that the largest element is always at the root. Every time we extract and remove it, a sift-down operation is performed, which restores the heap property.





<b> Time complexity </b>

For each element, two operations are performed: insertion with sift-up and removal with sift-down. Sifting operations have a time complexity of O(log n) since, at each level, only one element comparison is made. Therefore, the overall time complexity is O(n * 2 log n) -> O(n log n).


<b> Space complexity </b>

An array is required to store a tree that contains n elements for sorting. The spatial complexity is O(n).

</details>

<details>
<summary>
<b>RemoveNode</b>
</summary>

<a href="RemoveNode.java">Code</a>

Given a binary search tree storing unique integer keys, find the node with a specified key and remove it from the tree, ensuring that the tree remains a valid binary search tree. If the key is not present in the tree, there is no need to modify the tree. The function takes the root of the tree and the key to be deleted as input and should return the root of the modified tree. The time complexity of the node deletion should be O(h), where h is the height of the tree. Creating new nodes is not allowed.


<b>Input format</b>

The keys of the tree are natural numbers not exceeding 10^9. In the final solution, there is no need to define your own structure/class describing the tree node.


<b> Work principle </b>


First, I check if there is a tree at all. Then, I search for the element that needs to be replaced, and its parent node. If the element is not present, I do nothing and return the root.
If the element is present, I check if it is possible to find a replacement element. If there is a left part, I search for the rightmost element in it. If there is no left part but there is a right part, I search for the leftmost element in it. For replacement elements, there are two cases: when there is at least one vertex between the replacement element and the element to be deleted, and when the replacement element comes immediately after the vertex. Depending on this, I set the new children in the replacement element. If there is neither a left nor a right part, the replacement element remains null.
If the replacement element has no parent, it means we are deleting the root and return the replacement element. If there is a parent, I set the replacement element as the required child.


<b> The proof of correctness </b>

To delete an element and preserve the tree structure, you need to replace it with an element that will correctly separate the two remaining subtrees. This should be the largest element from the left part or the smallest from the right.



<b> Time complexity </b>

First, we search for the required element in O(H) in the worst case, where H is the height of the tree. If it's O(H), then it's a leaf with no children, and the replacement element will be null, so the complexity won't change. If the element is in the middle, we search for it in O(H - n), the height of the subtree. Then we search for the replacement element in O(n). In the end, O(H - n + n) -> O(H).

<b> Space complexity </b>

Saving the element to be deleted along with its parent and the replacement element with its parent separately. Complexity O(4) -> O(1).


</details>

## 6. Graphs

---

<details>
<summary>
<b>ExpensiveNet</b>
</summary>

<a href="ExpensiveNet.java">Code</a>

Timofey decided to connect all computers in his company into a single network. To achieve this, he came up with the idea of building a minimum spanning tree to use resources more efficiently.

However, news came from the management that the allocated budget for the network turned out to be very large, and it urgently needs to be spent. Therefore, Timofey is now interested in finding not the minimum, but the maximum spanning trees.

He has assigned you the task of finding the weight of such a maximum spanning tree in an undirected graph that represents the office layout.

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

The first line contains the number of vertices n and edges m in the graph (1 ≤ n ≤ 1000, 0 ≤ m ≤ 100000).

Each of the next m lines describes an edge with three numbers u, v, w. u and v are the vertices connected by this edge, and w is its weight (1 ≤ u, v ≤ n, 0 ≤ w ≤ 10000). The graph may contain loops and multiple edges. The graph may be disconnected.

<b>Output format</b>

If a maximum spanning tree exists, output its weight. Otherwise, (if the graph has multiple connected components), output the phrase "Oops! I did it again."

<b> Work principle </b>


To build a spanning tree, I used Prim's algorithm. There is a set of vertices that are already in the tree and a set for those that are not yet added. Additionally, a map with edges and their weights is created. When I add a vertex to the added set, I also add all its edges to the map. Then, I search for the largest value in this map for the vertices that are not yet in the added set. I repeat this process until there are no more edges or vertices. If there are remaining vertices but no more edges, it means there are multiple connected components in the graph.



<b> The proof of correctness </b>

Since we keep track of both visited and unvisited vertices, we can determine if we have added all vertices exactly once to the spanning tree.




<b> Time complexity </b>

The complexity of the algorithm is O(log(V) * E) since it utilizes a priority queue, where insertion and deletion operations are performed in O(logV) time. Here, V is the number of vertices, and E is the number of edges in the graph.


<b> Space complexity </b>

There is a matrix to store the graph (V*V), a priority queue to store the edges (E), and an array to store information about added vertices (V). Therefore, the spatial complexity is O(V^2 + E + V) -> O(V^2 + E), where V is the number of vertices, and E is the number of edges in the graph.



</details>

<details>
<summary>
<b>Railways</b>
</summary>

<a href="Railways.java">Code</a>

In country X, there are n cities numbered from 1 to n. The capital of the country has the number n. Iron roads connect the cities.

However, the roads can be of two types based on the width of the track. Any train can only travel on one type of track. Conventionally, one type of road is marked as R, and the other as B. This means that if the route from one city to another has both R-type and B-type roads, then no train will be able to travel on this route. One can travel from one city to another only on a route consisting exclusively of R-type roads or only of B-type roads.

But that's not all. In country X, you can only move along the roads from a city with a smaller number to a city with a larger number. This explains the large influx of residents to the capital, which has the number n.

The map of iron roads is called optimal if there is no pair of cities A and B such that it is possible to reach from A to B both via R-type roads and via B-type roads. In other words, for any pair of cities, it is true that from the city with a smaller number to the city with a larger number, you can only travel on roads of a certain type, or it is impossible to build a route at all. Determine whether the given map is optimal.

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

The first line contains the number n (1 ≤ n ≤ 5000) — the number of cities in the country. The map of iron roads is then provided in the following format.

The map is represented by n-1 lines. In the i-th line, roads from city i to cities i+1, i+2, ..., n are described. The line contains n - i characters, each of which is either R or B. If the j-th character of the i-th line is "B", then there is a road of type "B" from city i to city i + j. Similarly, for the type "R".

<b>Output format</b>

Output "YES" if the map is optimal, and "NO" otherwise.

<b> Work principle </b>


The cycle detection is performed using DFS. If during the verification of vertices, one of them turns out to be gray (i.e., the work with it is not yet finished), then there is a cycle in the graph.


<b> The proof of correctness </b>

We know that a directed graph is given, where all edges are directed in one direction from the city with a smaller number to the larger one. Since we have two types of roads to distinguish them, we can reverse the 'B' type from the last vertex to the first one. This way, R-roads will be directed from the smaller city to the larger one, and B-roads will be directed from the larger city to the smaller one. If we do this, in graphs where there are at least two paths to any vertex, cycles will appear.




<b> Time complexity </b>

Since the graph is represented as adjacency lists, the complexity of DFS will be O(V + E), where V is the number of vertices, and E is the number of edges in the graph.

<b> Space complexity </b>

To implement DFS without recursion, a stack is required, which will, at some point, contain all the vertices of the graph. Additionally, we store the graph as a list of lists. Therefore, the spatial complexity will be O(V + E), where V is the number of vertices, and E is the number of edges in the graph.


</details>

## 7. Greedy Algorithms and Dynamic Programming

---

<details>
<summary>
<b>LevenshteinDistance</b>
</summary>

<a href="LevenshteinDistance.java">Code</a>

The Levenshtein distance between two strings, s and t, is defined as the number of atomic changes required to transform one string into the other. Atomic changes include deleting one character, inserting one character, and replacing one character with another.

Find the Levenshtein distance for the given pair of strings.

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

The first line contains the string "s," and the second line contains the string "t." The lengths of both strings do not exceed 1000. The strings consist of lowercase Latin letters.

<b>Output format</b>

Output a single number — the distance between the strings.

<b> Work principle </b>


We need a two-dimensional matrix, but since the calculations are done along the last row, we will only store it.
The base case is dp[j] = j. Fill in the first row like this. Then the zero element will be equal to i -> the ordinal number of the loop.
The transition of the dynamics is to compare the values currentDp[j-1] + 1, dp[j] + 1, and dp[j-1] + 1 (if the letters are not equal) / dp[j-1] (if they are equal).
Choose the smallest number.
The answer to the original question will be contained in the cell dp[length of the second word].


<b> The proof of correctness </b>

The first line, dp[j] = j -> to get a string from an empty one, you need to perform j insertion operations. The first symbol of subsequent lines dp[0] = i -> to get an empty string from the current one, you need to perform i deletion operations.

If both strings are not empty:
- If the characters are equal, it means we haven't changed the last character, so we performed D(i - 1, j - 1) operations.
- If they are not equal, then we changed the last character once, so it's D(i - 1, j - 1) + 1.


<b> Time complexity </b>

To calculate, we use a nested loop based on the size of each of the strings being investigated (n and m). The complexity is O(n * m).

<b> Space complexity </b>

A supplementary array `dp` is required, with a length equal to the length of one of the strings being considered (n). We also store a temporary array in memory to fill the new row (n) and the actual strings (n and m). The complexity is O(3n + m) -> O(n + m).

</details>

<details>
<summary>
<b>SameSums</b>
</summary>

<a href="SameSums.java">Code</a>

Algos organized a table tennis tournament. Gosha won n matches, earning a certain number of points for each of them. Gosha became curious whether it is possible to split all the points he earned during the tournament into two parts so that the sum in each part is the same.

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

The first line contains an integer n (0 ≤ n ≤ 300), which is the number of won matches.

The second line contains n non-negative integers separated by a space, each of which does not exceed 300, representing the points earned in each match.

<b>Output format</b>

You need to output True if it is possible to make such a split, otherwise, output False.

<b> Work principle </b>


The array `dp` stores information about whether it is possible or not to compose a number equal to the index of the current element i from the elements of the `numbers` array. The `dp` array contains the count of values equal to half the sum of all numbers in the `numbers` array (median) + 1.
The base case is dp[0] = true.
The dynamic transition is as follows: for each element from `numbers`, iterate through `dp`. If dp[i] = true, add the current element from `numbers` to i.
The answer to the original question will be contained in the dp[median] cell.



<b> The proof of correctness </b>

If the element dp[i] = true, it means that it is possible to compose the sum i from the numbers without considering the current number. Add the current number to i if it does not go beyond the array boundaries, mark it in dp. In the end, after going through all the numbers, if dp[median] = true, it means that it is possible to compose the desired sum.





<b> Time complexity </b>

To calculate, iterate over all numbers (n) through the dp array (m). The time complexity is O(n * m).

<b> Space complexity </b>

Store all numbers (n), and also require an array dp to store the results of intermediate calculations (m). The spatial complexity is O(n + m).

</details>

## 8. Algorithms on strings

---

<details>
<summary>
<b>PackedPrefix</b>
</summary>

<a href="PackedPrefix.java">Code</a>

You are given strings in a packed form. Let's define a packed string (PS) recursively. A string consisting only of lowercase letters of the English alphabet is a PS. If A and B are correct PS, then AB is also a PS. If A is a PS and n is a single-digit natural number, then n[A] is also a PS. In this case, the notation n[A] means that when unpacking the string A, it is repeated n times in a row. Find the longest common prefix of unpacked strings and output it (in the unpacked form).

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

The first line contains the number n (1 ≤ n ≤ 1000) — the number of strings.

Then, in the next n lines, there are packed strings. It is guaranteed that these strings are correct, meaning they satisfy the specified recursive definition. The length of the strings after unpacking does not exceed 10^5.

<b>Output format</b>

Output the largest common prefix of the unpacked strings.

<b> Work principle </b>


To unpack the string, I use a stack with a list of characters and a stack with numbers - the number of repetitions. I go through each character in the string. If it is a number, then I add a new list to the stack of characters, and this number to the stack of numbers. If it is a character, I check if there are elements in the stack. If it is empty, it means that the current character does not need to be repeated, and I can add it to the final result. If there are elements, it means that they need to be repeated, so I add the character to the top list in the stack.

If the character is a closing bracket, it means that I need to extract the top list from the stack and add it to the resulting string, repeating it n times.

To determine the common prefix, I use a simple loop based on the number of characters in the smallest string and a counter. If all characters are equal, I look at the next one. If not, the loop is broken, and the current value of the counter is output.

<b> The proof of correctness </b>

To correctly unpack the string, we need to use the Last-In-First-Out (LIFO) principle, which is the foundation of a stack.



<b> Time complexity </b>

To unpack the string, we use a loop over all characters of the string n.
For finding the prefix, we use a loop over all characters of the smallest string, which will also be equal to n.
Thus, the time complexity will be O(2n * x) -> O(n * x), where x is the number of strings to compare, and n is the average number of characters in a string.

<b> Space complexity </b>

We need a stack of numbers and a stack of characters, the total number of characters in which will be n. Also, we store the resulting string in a StringBuilder format and a list of all prepared strings for finding the prefix.
The space complexity is O(x * n), where x is the number of strings to compare, and n is the average number of characters in a string.

</details>

<details>
<summary>
<b>Crib</b>
</summary>

<a href="Crib.java">Code</a>

Vasya is preparing for an algorithms exam and, just in case, is writing cheat sheets. To fit as much information as possible, he does not separate words with spaces. As a result, he gets one very long string. To avoid getting confused during the exam due to nervousness, he asks you to write a program that, given this long string and a set of permissible words, determines whether the text can be split into separate words from the set.

More formally: given the text T and a set of strings s1, ..., sn. It is necessary to determine whether T can be represented as sk1sk2...skr, where ki are the indices of strings. Indices can be repeated. String si can appear any number of times in the text T partitioning. It is not necessary to use all strings for the partitioning. Strings can appear in any order.

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

**Input format:**

The first line contains the text T that needs to be split into words. The length of T does not exceed 100100. The text consists of lowercase English letters.

The second line contains the number of allowable words 1 ≤ n ≤ 100.

The next n lines contain the words themselves, consisting of lowercase Latin letters. The length of each word does not exceed 100.

**Output format:**

Output "YES" if the text can be split into words from the given dictionary, or "NO" otherwise.

**Work principle:**

Build a trie. Then, using it, iterate through the given set of characters using dynamic programming.
The dp array will store a boolean value, which indicates whether the current character is a potential word start or not.
Iterate through all characters in the set in a loop. If the current character is a potential word start, we need to find the beginning of the next word. First, set the current node of the tree as its root.
Next, iterate through the loop, starting from the potential word start to the end of the array.
If the character is in the Children of the current node, check if this character is the end of a word. If yes, set the next character as a potential word start in dp. If the character is not present, break the loop.
In the end, if it is possible to form a chain of the specified words without gaps from the set of characters, then the last element in the dp array will be true.

**The proof of correctness:**

We use a trie to save memory. If the isWord field is true, it means a correct word can be formed along the specified path.
We use this to find all possible word options and the index of the potential beginning of a new word.

**Time complexity:**

Building the trie requires O(n), where n is the total number of characters in all words. Searching for potential words requires two loops - the first one over all characters in the given sequence m, the second one inside the first over part of the sequence. In the worst case, searching for all potential words takes O(n^2).

**Space complexity:**

Additional memory is required to store the examined string and all potential words in the form of a tree. The size of the tree is O(n * m), where n is the maximum length of a word, and m is the number of letters in the alphabet.

</details>
