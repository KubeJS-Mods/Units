package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class NegateOpUnit extends UnaryOpUnit {
	public NegateOpUnit(Unit unit) {
		super(UnitSymbol.BIT_NOT, unit);
	}

	@Override
	public double get(UnitVariables variables) {
		return -unit.get(variables);
	}

	@Override
	public int getInt(UnitVariables variables) {
		return -unit.getInt(variables);
	}
}
