package com.projectreactor.reactor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class ReactorApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux.just("test","test1","test2")
				.filter(s->s.length()>2)
				.map(s->s.concat("hello"))
				.subscribe(System.out::println);



		List<String> a = new LinkedList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("x");
		a.add("y");
		a.add("z");
		List<String> b = new LinkedList<String>();
		b.add("d");
		b.add("e");
		b.add("f");
		b.add("x");
		b.add("y");
		b.add("z");

		Iterator<String> aIter = a.iterator();


		List<String> result = new LinkedList<>();
		String equalValue = "";

		boolean flag = false;

		while(aIter.hasNext()){
			String aTemp = aIter.next();
			Iterator<String> bIter = b.iterator();
			if(flag == true){
				result.add(aTemp);
			}else {
				while (bIter.hasNext()) {
					String bTemp = bIter.next();
					if (aTemp.compareTo(bTemp) < 0) {
						result.add(aTemp);
						break;
					} else if (aTemp.compareTo(bTemp) > 0) {
						result.add(bTemp);
						bIter.remove();
					} else {
						equalValue = aTemp;
						flag = true;
					}
				}
			}
		}


		System.out.println(Arrays.toString(result.toArray()));
		System.out.println("equalValue:"+equalValue);

	}




}
