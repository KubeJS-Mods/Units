package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;

public abstract class Func3Unit extends FuncUnit {
	public final Unit a, b, c;

	public Func3Unit(FunctionFactory factory, Unit a, Unit b, Unit c) {
		super(factory);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	protected Unit[] getArguments() {
		return new Unit[]{a, b, c};
	}
}
