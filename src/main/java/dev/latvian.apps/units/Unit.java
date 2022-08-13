package dev.latvian.apps.units;

import dev.latvian.apps.units.function.AbsFuncUnit;
import dev.latvian.apps.units.function.Atan2FuncUnit;
import dev.latvian.apps.units.function.AtanFuncUnit;
import dev.latvian.apps.units.function.BoolFuncUnit;
import dev.latvian.apps.units.function.CeilFuncUnit;
import dev.latvian.apps.units.function.ClampFuncUnit;
import dev.latvian.apps.units.function.CosFuncUnit;
import dev.latvian.apps.units.function.DegFuncUnit;
import dev.latvian.apps.units.function.FloorFuncUnit;
import dev.latvian.apps.units.function.LerpFuncUnit;
import dev.latvian.apps.units.function.Log10FuncUnit;
import dev.latvian.apps.units.function.Log1pFuncUnit;
import dev.latvian.apps.units.function.LogFuncUnit;
import dev.latvian.apps.units.function.MaxFuncUnit;
import dev.latvian.apps.units.function.MinFuncUnit;
import dev.latvian.apps.units.function.RadFuncUnit;
import dev.latvian.apps.units.function.SinFuncUnit;
import dev.latvian.apps.units.function.SmoothstepFuncUnit;
import dev.latvian.apps.units.function.SqFuncUnit;
import dev.latvian.apps.units.function.SqrtFuncUnit;
import dev.latvian.apps.units.function.TanFuncUnit;
import dev.latvian.apps.units.function.WithAlphaFuncUnit;
import dev.latvian.apps.units.operator.BitNotOpUnit;
import dev.latvian.apps.units.operator.BoolNotOpUnit;
import dev.latvian.apps.units.operator.NegateOpUnit;
import dev.latvian.apps.units.operator.SetUnit;
import dev.latvian.apps.units.operator.cond.AndOpUnit;
import dev.latvian.apps.units.operator.cond.EqOpUnit;
import dev.latvian.apps.units.operator.cond.GtOpUnit;
import dev.latvian.apps.units.operator.cond.GteOpUnit;
import dev.latvian.apps.units.operator.cond.LtOpUnit;
import dev.latvian.apps.units.operator.cond.LteOpUnit;
import dev.latvian.apps.units.operator.cond.NeqOpUnit;
import dev.latvian.apps.units.operator.cond.OrOpUnit;
import dev.latvian.apps.units.operator.op.AddOpUnit;
import dev.latvian.apps.units.operator.op.BitAndOpUnit;
import dev.latvian.apps.units.operator.op.BitOrOpUnit;
import dev.latvian.apps.units.operator.op.DivOpUnit;
import dev.latvian.apps.units.operator.op.LshOpUnit;
import dev.latvian.apps.units.operator.op.ModOpUnit;
import dev.latvian.apps.units.operator.op.MulOpUnit;
import dev.latvian.apps.units.operator.op.PowOpUnit;
import dev.latvian.apps.units.operator.op.RshOpUnit;
import dev.latvian.apps.units.operator.op.SubOpUnit;
import dev.latvian.apps.units.operator.op.XorOpUnit;
import dev.latvian.apps.units.token.UnitSymbol;

public abstract class Unit {
	public static Unit[] EMPTY_ARRAY = new Unit[0];

	public boolean isFixed() {
		return false;
	}

	public abstract double get(UnitVariables variables);

	public float getFloat(UnitVariables variables) {
		return (float) get(variables);
	}

	public int getInt(UnitVariables variables) {
		double d = get(variables);
		int i = (int) d;
		return d < (double) i ? i - 1 : i;
	}

	public boolean getBoolean(UnitVariables variables) {
		return get(variables) != 0D;
	}

	public void toString(StringBuilder builder) {
		builder.append(this);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		toString(builder);
		return builder.toString();
	}

	// Operators

	public Unit positive() {
		return this;
	}

	public Unit negate() {
		return new NegateOpUnit(this);
	}

	public Unit add(Unit other) {
		return new AddOpUnit(this, other);
	}

	public Unit add(double value) {
		return add(FixedNumberUnit.of(value));
	}

	public Unit sub(Unit other) {
		return new SubOpUnit(this, other);
	}

	public Unit sub(double value) {
		return sub(FixedNumberUnit.of(value));
	}

	public Unit mul(Unit other) {
		return new MulOpUnit(this, other);
	}

	public Unit mul(double value) {
		return add(FixedNumberUnit.of(value));
	}

	public Unit div(Unit other) {
		return new DivOpUnit(this, other);
	}

	public Unit div(double value) {
		return add(FixedNumberUnit.of(value));
	}

	public Unit mod(Unit other) {
		return new ModOpUnit(this, other);
	}

	public Unit mod(double value) {
		return mod(FixedNumberUnit.of(value));
	}

	public Unit pow(Unit other) {
		return new PowOpUnit(this, other);
	}

	public Unit lsh(Unit other) {
		return new LshOpUnit(this, other);
	}

	public Unit rsh(Unit other) {
		return new RshOpUnit(this, other);
	}

	public Unit bitAnd(Unit other) {
		return new BitAndOpUnit(this, other);
	}

	public Unit bitOr(Unit other) {
		return new BitOrOpUnit(this, other);
	}

	public Unit xor(Unit other) {
		return new XorOpUnit(this, other);
	}

	public Unit bitNot() {
		return new BitNotOpUnit(this);
	}

	public Unit eq(Unit other) {
		return new EqOpUnit(this, other);
	}

	public Unit neq(Unit other) {
		return new NeqOpUnit(this, other);
	}

	public Unit lt(Unit other) {
		return new LtOpUnit(this, other);
	}

	public Unit gt(Unit other) {
		return new GtOpUnit(this, other);
	}

	public Unit lte(Unit other) {
		return new LteOpUnit(this, other);
	}

	public Unit gte(Unit other) {
		return new GteOpUnit(this, other);
	}

	public Unit and(Unit other) {
		return new AndOpUnit(this, other);
	}

	public Unit or(Unit other) {
		return new OrOpUnit(this, other);
	}

	public Unit boolNot() {
		return new BoolNotOpUnit(this);
	}

	// Functions

	public Unit min(Unit other) {
		return new MinFuncUnit(this, other);
	}

	public Unit max(Unit other) {
		return new MaxFuncUnit(this, other);
	}

	public Unit abs() {
		return new AbsFuncUnit(this);
	}

	public Unit sin() {
		return new SinFuncUnit(this);
	}

	public Unit cos() {
		return new CosFuncUnit(this);
	}

	public Unit tan() {
		return new TanFuncUnit(this);
	}

	public Unit deg() {
		return new DegFuncUnit(this);
	}

	public Unit rad() {
		return new RadFuncUnit(this);
	}

	public Unit atan() {
		return new AtanFuncUnit(this);
	}

	public Unit atan2(Unit other) {
		return new Atan2FuncUnit(this, other);
	}

	public Unit log() {
		return new LogFuncUnit(this);
	}

	public Unit log10() {
		return new Log10FuncUnit(this);
	}

	public Unit log1p() {
		return new Log1pFuncUnit(this);
	}

	public Unit sqrt() {
		return new SqrtFuncUnit(this);
	}

	public Unit sq() {
		return new SqFuncUnit(this);
	}

	public Unit floor() {
		return new FloorFuncUnit(this);
	}

	public Unit ceil() {
		return new CeilFuncUnit(this);
	}

	public Unit bool() {
		return new BoolFuncUnit(this);
	}

	public Unit clamp(Unit a, Unit b) {
		return new ClampFuncUnit(this, a, b);
	}

	public Unit lerp(Unit a, Unit b) {
		return new LerpFuncUnit(this, a, b);
	}

	public Unit smoothstep() {
		return new SmoothstepFuncUnit(this);
	}

	public Unit withAlpha(Unit a) {
		return new WithAlphaFuncUnit(this, a);
	}

	public Unit set(Unit unit) {
		return new SetUnit(UnitSymbol.SET, this, unit);
	}

	public Unit addSet(Unit unit) {
		return new SetUnit(UnitSymbol.ADD_SET, this, add(unit));
	}

	public Unit subSet(Unit unit) {
		return new SetUnit(UnitSymbol.SUB_SET, this, sub(unit));
	}

	public Unit mulSet(Unit unit) {
		return new SetUnit(UnitSymbol.MUL_SET, this, mul(unit));
	}

	public Unit divSet(Unit unit) {
		return new SetUnit(UnitSymbol.DIV_SET, this, div(unit));
	}

	public Unit modSet(Unit unit) {
		return new SetUnit(UnitSymbol.MOD_SET, this, mod(unit));
	}
}
