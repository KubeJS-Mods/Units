package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class DegFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("deg", Unit::deg);

	public DegFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.toDegrees(a.get(variables));
	}
}
