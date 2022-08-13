package dev.latvian.apps.units.operator.op;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.operator.OpUnit;
import dev.latvian.apps.units.token.UnitSymbol;

public class RshOpUnit extends OpUnit {
	public RshOpUnit(Unit left, Unit right) {
		super(UnitSymbol.RSH, left, right);
	}

	@Override
	public double get(UnitVariables variables) {
		return getInt(variables);
	}

	@Override
	public int getInt(UnitVariables variables) {
		return left.getInt(variables) >> right.getInt(variables);
	}
}
