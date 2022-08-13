package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class BitNotOpUnit extends UnaryOpUnit {
	public BitNotOpUnit(Unit unit) {
		super(UnitSymbol.BIT_NOT, unit);
	}

	@Override
	public double get(UnitVariables variables) {
		return getInt(variables);
	}

	@Override
	public int getInt(UnitVariables variables) {
		return ~unit.getInt(variables);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return !unit.getBoolean(variables);
	}
}
