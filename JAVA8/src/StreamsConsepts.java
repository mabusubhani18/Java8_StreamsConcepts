import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsConsepts {

	public static void main(String[] args) {
		//Ex1:- print the numbers of range is 1 to 10.		
		IntStream.range(1,10).forEach(System.out::print);// O/P: 123456789	
		System.out.println("");
		//Ex2:- print the numbers range is 1 to 10 and in skip upto 1 to 5.
		IntStream.range(1, 10).skip(5).forEach(System.out::print);//o/p:6789
		//Ex3:- print the numbers range is 1 to 5 and sum of those numbers.
		System.out.println(IntStream.range(1,5).sum());//O/P:10		
		//Ex4:- Stream.of() sorted and findFirs
		Stream.of("Ava","Aneri","Alberto").sorted().findFirst().ifPresent(System.out::println);//Alberto
		//Ex5:stream from Array, Sort,filter and print
		String[] names= {"Al#","Ankit#","Kushal#","Brent#","Sarika#","Amanda#","Hans#","Shivika#","Sankar#"};
		Arrays.stream(names).filter(x->x.startsWith("S")).sorted().forEach(System.out::print);
		//Ex6:-Average of squares of an int array
		System.out.println("");
		int[] a= {2,4,6,8,10};
		Arrays.stream(a).map(x->x*x).average().ifPresent(System.out::print);
		//Ex7:-Stream from List,filter and print
		System.out.println("");
		List<String> people=Arrays.asList("Al#","Ankit#","Kushal#","Brent#","Sarika#","Amanda#","Hans#","Shivika#","Sankar#");
		people.stream().map(String::toLowerCase).filter(x->x.startsWith("a")).forEach(System.out::print);
		System.out.println("");
		//Ex8:-Print repitad word count given sentance 
		String sentence ="mango apple mango banana apple banana mango";
		String[] word=sentence.split(" ");
		System.out.println(Arrays.asList(word).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	    //Ex9:-For example, i have an array list which has duplicate elements.
		List<Integer> intList=Arrays.asList(1,2,3,2,6,7,5,3,1);
		System.out.println(intList); // [1, 2, 3, 2, 6, 7, 5, 3, 1]
		//Remove the duplicates and print the list using stream api.
		System.out.println(intList.stream().distinct().collect(Collectors.toList()));//[1, 2, 3, 6, 7, 5]
		//Print the duplicated list using stream api.
		System.out.println(intList.stream().filter(i->Collections.frequency(intList, i)>1).collect(Collectors.toSet()));//// [1, 2, 3]
		//Print the non duplicated list using stream api. 
		System.out.println(intList.stream().filter(i->Collections.frequency(intList, i)==1).collect(Collectors.toList()));//// [6, 7, 5]
		//Print the frequency of elements present in the given list using stream api.
		System.out.println(intList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));//{1=2, 2=2, 3=2, 5=1, 6=1, 7=1}
	}

}
