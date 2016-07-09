package com.pratik.lambda;

import java.util.function.Consumer;

/**
 * Lambda's capture variables in external scope. A variable re-defined in an enclosing scope must
 * be final or effectively final.
 *
 */
public class LambdaScope {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {

			//Local variable x defined in an enclosing scope must be final or effectively 
			//final
			//x = 99;
			
			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x); // Statement A
				System.out.println("y = " + y);
				System.out.println("this.x = " + this.x);
				System.out.println("LambdaScope.this.x = " + LambdaScope.this.x);
			};
			
			 myConsumer.accept(x);
		}

	}

	public static void main(String[] args) {
		LambdaScope ls = new LambdaScope();
		LambdaScope.FirstLevel fl = ls.new FirstLevel();
		fl.methodInFirstLevel(23);

	}

}
