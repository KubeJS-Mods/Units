package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class FloorFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("floor", Unit::floor);

	public FloorFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.floor(a.get(variables));
	}
}
