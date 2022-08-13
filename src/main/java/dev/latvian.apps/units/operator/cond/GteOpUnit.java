package dev.latvian.apps.units.operator.cond;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class GteOpUnit extends CondOpUnit {
	public GteOpUnit(Unit left, Unit right) {
		super(UnitSymbol.GTE, left, right);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return left.get(variables) >= right.get(variables);
	}
}
