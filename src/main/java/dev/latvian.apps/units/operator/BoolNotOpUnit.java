package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class BoolNotOpUnit extends UnaryOpUnit {
	public BoolNotOpUnit(Unit unit) {
		super(UnitSymbol.BOOL_NOT, unit);
	}

	@Override
	public double get(UnitVariables variables) {
		return getBoolean(variables) ? 1.0D : 0.0D;
	}

	@Override
	public int getInt(UnitVariables variables) {
		return getBoolean(variables) ? 1 : 0;
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return !unit.getBoolean(variables);
	}
}
