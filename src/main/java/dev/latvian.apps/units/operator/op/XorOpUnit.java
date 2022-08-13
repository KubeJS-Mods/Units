package dev.latvian.apps.units.operator.op;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.operator.OpUnit;
import dev.latvian.apps.units.token.UnitSymbol;

public class XorOpUnit extends OpUnit {
	public XorOpUnit(Unit left, Unit right) {
		super(UnitSymbol.XOR, left, right);
	}

	@Override
	public double get(UnitVariables variables) {
		return getInt(variables);
	}

	@Override
	public int getInt(UnitVariables variables) {
		return left.getInt(variables) ^ right.getInt(variables);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return left.getBoolean(variables) ^ right.getBoolean(variables);
	}
}
