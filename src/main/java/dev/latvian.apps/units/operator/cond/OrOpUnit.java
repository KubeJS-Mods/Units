package dev.latvian.apps.units.operator.cond;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class OrOpUnit extends CondOpUnit {
	public OrOpUnit(Unit left, Unit right) {
		super(UnitSymbol.OR, left, right);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return left.getBoolean(variables) || right.getBoolean(variables);
	}
}
