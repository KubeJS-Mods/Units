package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.token.UnitSymbol;

public abstract class UnaryOpUnit extends Unit {
	public final UnitSymbol symbol;
	public Unit unit;

	public UnaryOpUnit(UnitSymbol symbol, Unit unit) {
		this.symbol = symbol;
		this.unit = unit;
	}

	@Override
	public void toString(StringBuilder builder) {
		builder.append('(');
		builder.append(symbol);
		unit.toString(builder);
		builder.append(')');
	}
}