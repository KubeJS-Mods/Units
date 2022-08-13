package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class PowFuncUnit extends Func2Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of2("pow", Unit::pow);

	public PowFuncUnit(Unit a, Unit b) {
		super(FACTORY, a, b);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.pow(a.get(variables), b.get(variables));
	}
}
