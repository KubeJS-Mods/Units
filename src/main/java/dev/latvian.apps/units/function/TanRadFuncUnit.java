package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class TanRadFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("tanRad", Unit::tan);

	public TanRadFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.tan(a.get(variables));
	}
}
