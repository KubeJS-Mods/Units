package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class Atan2FuncUnit extends Func2Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of2("atan2", Unit::atan2);

	public Atan2FuncUnit(Unit a, Unit b) {
		super(FACTORY, a, b);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.atan2(a.get(variables), b.get(variables));
	}
}
