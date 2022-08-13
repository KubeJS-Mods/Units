package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class SinFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("sin", Unit::sin);

	public SinFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.sin(a.get(variables));
	}
}
