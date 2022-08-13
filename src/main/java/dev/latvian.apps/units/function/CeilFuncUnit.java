package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class CeilFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("ceil", Unit::ceil);

	public CeilFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.ceil(a.get(variables));
	}
}
