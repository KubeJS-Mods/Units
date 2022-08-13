package dev.latvian.apps.units.token;

import dev.latvian.apps.units.Unit;

public record UnaryOpUnitToken(UnitSymbol operator, UnitToken token) implements UnitToken {
	@Override
	public Unit interpret(UnitTokenStream stream) {
		var unit = token.interpret(stream);
		return operator.unaryOp.create(unit);
	}

	@Override
	public String toString() {
		return "(" + operator + token + ")";
	}
}
