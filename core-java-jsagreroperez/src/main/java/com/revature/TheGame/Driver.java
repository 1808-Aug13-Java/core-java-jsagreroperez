package com.revature.TheGame;

import java.util.Collections;
import java.util.LinkedList;

import com.revature.collections.Pizza;

public class Driver {

	public static void main(String[] args) {
		
		
		System.out.println("Before using utility class's sort method:");
		LinkedList<TheGame> foodList = new LinkedList<TheGame>();
		foodList.add(new TheGame("miguel", "what is 2+2"));
		foodList.add(new TheGame("Jorge" ,"what is 1+1"));
		foodList.add(new TheGame("manuel", "what is 3+1"));
		for(TheGame p : foodList) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("After using utility class's sort method:");
		Collections.sort(foodList);
		for(TheGame p : foodList) {
			System.out.println(p);
		}
		System.out.println();
		
		
		System.out.println("Before using utility class's sort method:");
		LinkedList<questions> quest = new LinkedList<questions>();
		quest.add(new questions("what is 2+2"));
		quest.add(new questions("what is 1+1"));
		quest.add(new questions("what is 3+1"));
		for(questions p : quest) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("After using utility class's sort method:");
		Collections.sort(quest);
		for(questions p : quest) {
			System.out.println(p);
		}
		questions p;
		TheGame k;
		for(int i = 0; i<3; i ++)
		{
			p = quest.pop();
			k = foodList.pop();
			System.out.print(k);
			System.out.println(p);
		}
		System.out.println();
		
	}
}
