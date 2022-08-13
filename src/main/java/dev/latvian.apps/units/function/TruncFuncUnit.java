package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class TruncFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("trunc", Unit::trunc);

	public TruncFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return (long) a.get(variables);
	}
}