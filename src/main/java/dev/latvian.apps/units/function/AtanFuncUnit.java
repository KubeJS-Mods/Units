package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class AtanFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("atan", Unit::atan);

	public AtanFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.atan(a.get(variables));
	}
}
