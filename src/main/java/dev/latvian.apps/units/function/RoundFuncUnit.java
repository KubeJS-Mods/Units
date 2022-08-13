package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class RoundFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("round", Unit::rad);

	public RoundFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.round(a.get(variables));
	}
}