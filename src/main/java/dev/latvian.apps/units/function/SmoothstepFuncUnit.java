package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class SmoothstepFuncUnit extends Func1Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of1("smoothstep", Unit::smoothstep);

	public SmoothstepFuncUnit(Unit a) {
		super(FACTORY, a);
	}

	@Override
	public double get(UnitVariables variables) {
		double d = a.get(variables);
		return d * d * d * (d * (d * 6D - 15D) + 10D);
	}
}
