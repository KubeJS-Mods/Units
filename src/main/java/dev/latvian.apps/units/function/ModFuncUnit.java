package dev.latvian.apps.units.function;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

public class ModFuncUnit extends Func2Unit {
	public static final FunctionFactory FACTORY = FunctionFactory.of2("mod", Unit::mod);

	public ModFuncUnit(Unit a, Unit b) {
		super(FACTORY, a, b);
	}

	@Override
	public double get(UnitVariables variables) {
		return a.get(variables) % b.get(variables);
	}
}
