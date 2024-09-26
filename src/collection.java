import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class collection {
	public static void main(String[] args) {
//_____________________________________List_____________________________________________
//Array List
		List<String> stringList = new ArrayList<>();
		stringList.add("Hello");
		stringList.add("World");
		stringList.add("!");
		for (String element : stringList) {
			System.out.print(element + " ");

		}
//_____________________Set______________________
//HashSet
		Set<Integer> intSet = new HashSet<>();
		intSet.add(6);
		intSet.add(8);
		intSet.add(8); // false, only unique values
		for (Integer number : intSet) {
			System.out.print("\n" + number);
		}
//TreeSet____________ordered list by values
		Set<Integer> sortedSet = new TreeSet<>();
		sortedSet.add(3);
		sortedSet.add(7);
		sortedSet.add(27);
		sortedSet.add(7);
		for (Integer element : sortedSet) {
			System.out.print("\n" + element);
		}
//_________________________________Queue__________________________________________________		    
//first in, first out
//LinkedList
		Queue<String> line = new LinkedList<>();
		line.add("Mike");
		line.add("Isabel");
		line.add("Jenny");

		for (String name : line) {
			System.out.println("\n" + name);
		}
//PriorityQueue______________alphabetical sort_____smallest element___priority dara.
		processAlphabetically(line);
//_______________________________Deque______________________________________________
		List<Integer> myInts = new ArrayList<>();
		myInts.add(9);
		myInts.add(13);
		myInts.add(2);
		myInts.add(1);
		myInts.add(11);
		myInts.add(39);
		myInts.add(78);
		myInts.add(4);

		Deque<Integer> result = separateInts(myInts);
		for (Integer i : result) {
			System.out.println(i);
		}
//_____________________________________Collection____________________________________
		List<Integer> intList = new ArrayList<>();
		Set<String> stringSet = new HashSet<>();
		Queue<Double> doubleQueue = new LinkedList<>();
		Deque<Integer> intDeque = new ArrayDeque<>();
		intList.add(5);
		intList.add(8);
		intList.add(5);
		intList.add(1);

		stringSet.add("Hello");
		stringSet.add("World");
		stringSet.add("World");

		doubleQueue.add(3.89);
		doubleQueue.add(889.64);

		intDeque.addFirst(7);
		intDeque.addFirst(8);
		intDeque.addLast(40);
		System.out.println(intList.getClass());
		printCollection(intList);
		System.out.println();
		System.out.println(stringSet.getClass());
		printCollection(stringSet);
		System.out.println();
		System.out.println(doubleQueue.getClass());
		printCollection(doubleQueue);
		System.out.println();
		System.out.println(intDeque.getClass());
		printCollection(intDeque);
//_______________________________Collection Methods___________________________Amazing!____
		List<Integer> myList = new ArrayList<>();
		myList.add(3);
		myList.add(-1);
		myList.add(57);
		myList.add(29);
		// finds the minimum value
		System.out.println("myList min: " + Collections.min(myList));
		System.out.println();
		// to search for index of an element
		System.out.println("Index of 57 in myList is: " + Collections.binarySearch(myList, 57));
		System.out.println();
		// to reverse a list
		System.out.println("myList prior to reverse: ");
		printCollection2(myList);
		System.out.println();
		Collections.reverse(myList);
		System.out.println("myList reversed: ");
		printCollection2(myList);
		System.out.println();
		// to sort a list_______________________________
		System.out.println("myList prior to sort: ");
		printCollection2(myList);
		System.out.println();
		Collections.sort(myList);
		System.out.println("myList after sort: ");
		printCollection2(myList);

		Set<String> mySet = new HashSet<>();
		mySet.add("Hello");
		mySet.add("World");
		// to find the maximum
		System.out.println("mySet max: \"" + Collections.max(mySet) + "\"");
		System.out.println();
//___________________________________________Map_________________________________________
//an example to count the number of occurrences of each number in a list:
		List<Integer> myInts2 = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			myInts2.add(random.nextInt(5));
		}
		System.out.println("myInts: " + myInts2);
		Map<Integer, Integer> intCount = countNumbers(myInts2);
		for (Map.Entry<Integer, Integer> entry : intCount.entrySet()) {
			System.out.println("Integer: " + entry.getKey() + " appears: " + entry.getValue());
		}
//Stream__________________________________________aggregate operations____________
		List<String> words = new ArrayList<>();
		words.add("Tree");
		words.add("Hello");
		words.add("World");
		words.add("Race");
		words.add("Game");
		words.add("Numbers");
		words.add("Ride");

		List<String> specialWordsWithForLoop = getSpecialWordsWithForLoop(words);

		List<String> specialWordsWithPipeline = getSpecialWordsWithPipeline(words);

		System.out.println("Special Words retrieved from for loop: " + specialWordsWithForLoop);

		System.out.println("Special Words retrieved from pipeline: " + specialWordsWithPipeline);

	}

//Method for sorting elements alphabetical
	public static void processAlphabetically(Queue<String> queue) {
		Queue<String> alphabeticalQueue = new PriorityQueue<>();

		for (String name : queue) {
			alphabeticalQueue.offer(name);
		}
		while (alphabeticalQueue.peek() != null) {
			String headElement = alphabeticalQueue.poll();
			System.out.println("Processing: " + headElement);
		}
	}

//Method for separating odd and even numbers in a list using Deque________
	public static Deque<Integer> separateInts(List<Integer> integers) {
		Deque<Integer> separatedDeque = new ArrayDeque<>();
		for (Integer myInt : integers) {
			if (myInt % 2 == 0) {
				separatedDeque.addFirst(myInt);
			} else {
				separatedDeque.addLast(myInt);
			}
		}
		return separatedDeque;
	}

//Method for printing different core interfaces____________________Collection_____
	private static <T> void printCollection(Collection<T> collection) {
		for (T item : collection) {
			System.out.println(item);
		}
	}

//Method for iterating in different interfaces______________________________________
//collection method iterator()_______
	public static void printCollection2(Collection<?> collection) {
		Iterator<?> myItr = collection.iterator();

		while (myItr.hasNext()) {
			System.out.println(myItr.next());
		}

	}

	// Method to count the number of occurrences of each number in a list
	public static Map<Integer, Integer> countNumbers(List<Integer> list) {
		Map<Integer, Integer> intCount = new HashMap<>();
		for (Integer s : list) {
			if (intCount.get(s) == null) {
				intCount.put(s, 1);
			} else {
				int currentCount = intCount.get(s);
				currentCount++;
				intCount.put(s, currentCount);
			}
		}
		return intCount;
	}

//_____________________________Stream, Lambda, filter, ..._______________________________
//first method in a simple and basic way
	public static List<String> getSpecialWordsWithForLoop(List<String> words) {
		List<String> specialWords = new ArrayList<>();

		for (String word : words) {
			if (word.length() == 4) {
				String upperCaseWord = word.toUpperCase();
				specialWords.add(upperCaseWord);
			}
		}
		return specialWords;
	}

//second method uses stream, ... same example in another way
	public static List<String> getSpecialWordsWithPipeline(List<String> words) {
		List<String> specialWords = words.stream().filter(word -> word.length() == 4).map(word -> word.toUpperCase())
				.collect(Collectors.toList());

		return specialWords;
	}
}
