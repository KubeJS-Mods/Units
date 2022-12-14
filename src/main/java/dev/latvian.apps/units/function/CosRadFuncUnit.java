package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class CosRadFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("cosRad", Unit::cos);

	public CosRadFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.cos(a.get(variables));
	}
}
