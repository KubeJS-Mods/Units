package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class SqrtFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("sqrt", Unit::sqrt);

	public SqrtFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.sqrt(a.get(variables));
	}
}
