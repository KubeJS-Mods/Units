package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class CosFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("cos", Unit::cos);

	public CosFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.cos(Math.toRadians(a.get(variables)));
	}
}
