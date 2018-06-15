package joker.j8;

public class FunctionInterface implements Foo, Foo1 {

	@Override
	public void foo() {

	}

	public void foo1() {
		Foo1.super.foo1();
	}

}

@FunctionalInterface
interface Foo {
	abstract void foo();

	default void foo1() {
	}

	static void foo2() {
	}
}

@FunctionalInterface
interface Foo1 {
	abstract void foo();

	default void foo1() {
	}

	static void foo2() {
	}
}

@FunctionalInterface
interface FooExtend extends Foo, Foo1 {
	abstract void foo();

	default void foo1() {
	}

	static void foo2() {
	}
}
