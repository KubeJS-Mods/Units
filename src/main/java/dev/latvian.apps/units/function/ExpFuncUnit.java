package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class ExpFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("exp", Unit::exp);

	public ExpFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.exp(a.get(variables));
	}
}
