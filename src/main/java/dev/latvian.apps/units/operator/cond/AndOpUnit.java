package dev.latvian.apps.units.operator.cond;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class AndOpUnit extends CondOpUnit {
	public AndOpUnit(Unit left, Unit right) {
		super(UnitSymbol.AND, left, right);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return left.getBoolean(variables) && right.getBoolean(variables);
	}
}
