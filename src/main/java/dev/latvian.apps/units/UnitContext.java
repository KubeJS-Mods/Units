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
import dev.latvian.apps.units.function.FunctionFactory;
import dev.latvian.apps.units.function.HsvFuncUnit;
import dev.latvian.apps.units.function.LerpFuncUnit;
import dev.latvian.apps.units.function.Log10FuncUnit;
import dev.latvian.apps.units.function.Log1pFuncUnit;
import dev.latvian.apps.units.function.LogFuncUnit;
import dev.latvian.apps.units.function.MapFuncUnit;
import dev.latvian.apps.units.function.MaxFuncUnit;
import dev.latvian.apps.units.function.MinFuncUnit;
import dev.latvian.apps.units.function.RadFuncUnit;
import dev.latvian.apps.units.function.RandomUnit;
import dev.latvian.apps.units.function.RgbFuncUnit;
import dev.latvian.apps.units.function.RoundedTimeUnit;
import dev.latvian.apps.units.function.SinFuncUnit;
import dev.latvian.apps.units.function.SmoothstepFuncUnit;
import dev.latvian.apps.units.function.SqFuncUnit;
import dev.latvian.apps.units.function.SqrtFuncUnit;
import dev.latvian.apps.units.function.TanFuncUnit;
import dev.latvian.apps.units.function.TimeUnit;
import dev.latvian.apps.units.function.WithAlphaFuncUnit;
import dev.latvian.apps.units.token.UnitTokenStream;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UnitContext {
	public static final UnitContext DEFAULT = new UnitContext();

	static {
		DEFAULT.addFunction(TimeUnit.FACTORY);
		DEFAULT.addFunction(RoundedTimeUnit.FACTORY);
		DEFAULT.addFunction(RandomUnit.FACTORY);
		DEFAULT.addFunction(FunctionFactory.of3("if", TernaryUnit::new));
		DEFAULT.addFunction(RgbFuncUnit.FACTORY);

		DEFAULT.addFunction(MinFuncUnit.FACTORY);
		DEFAULT.addFunction(MaxFuncUnit.FACTORY);
		DEFAULT.addFunction(AbsFuncUnit.FACTORY);
		DEFAULT.addFunction(SinFuncUnit.FACTORY);
		DEFAULT.addFunction(CosFuncUnit.FACTORY);
		DEFAULT.addFunction(TanFuncUnit.FACTORY);
		DEFAULT.addFunction(DegFuncUnit.FACTORY);
		DEFAULT.addFunction(RadFuncUnit.FACTORY);
		DEFAULT.addFunction(AtanFuncUnit.FACTORY);
		DEFAULT.addFunction(Atan2FuncUnit.FACTORY);
		DEFAULT.addFunction(LogFuncUnit.FACTORY);
		DEFAULT.addFunction(Log10FuncUnit.FACTORY);
		DEFAULT.addFunction(Log1pFuncUnit.FACTORY);
		DEFAULT.addFunction(SqrtFuncUnit.FACTORY);
		DEFAULT.addFunction(SqFuncUnit.FACTORY);
		DEFAULT.addFunction(FloorFuncUnit.FACTORY);
		DEFAULT.addFunction(CeilFuncUnit.FACTORY);
		DEFAULT.addFunction(BoolFuncUnit.FACTORY);
		DEFAULT.addFunction(ClampFuncUnit.FACTORY);
		DEFAULT.addFunction(LerpFuncUnit.FACTORY);
		DEFAULT.addFunction(SmoothstepFuncUnit.FACTORY);
		DEFAULT.addFunction(HsvFuncUnit.FACTORY);
		DEFAULT.addFunction(WithAlphaFuncUnit.FACTORY);
		DEFAULT.addFunction(MapFuncUnit.FACTORY);

		DEFAULT.addConstant("true", FixedBooleanUnit.TRUE);
		DEFAULT.addConstant("false", FixedBooleanUnit.FALSE);
		DEFAULT.addConstant("PI", FixedNumberUnit.PI);
		DEFAULT.addConstant("TWO_PI", FixedNumberUnit.TWO_PI);
		DEFAULT.addConstant("HALF_PI", FixedNumberUnit.HALF_PI);
		DEFAULT.addConstant("E", FixedNumberUnit.E);
	}

	private final Map<String, FunctionFactory> functions = new HashMap<>();
	public final Map<String, Unit> constants = new HashMap<>();
	private final Map<String, Unit> cache = new HashMap<>();
	private int debug = -1;

	public void addFunction(FunctionFactory factory) {
		functions.put(factory.name(), factory);
	}

	@Nullable
	public FunctionFactory getFunctionFactory(String name) {
		var f = functions.get(name);

		if (f == null && name.startsWith("math.")) {
			return functions.get(name.substring(5));
		}

		return f;
	}

	public void addConstant(String s, Unit u) {
		constants.put(s, u);
	}

	public UnitContext sub() {
		UnitContext ctx = new UnitContext();
		ctx.functions.putAll(functions);
		ctx.debug = debug;
		return ctx;
	}

	public UnitTokenStream createStream(String input) {
		return new UnitTokenStream(this, input);
	}

	public Unit parse(String input) {
		Unit u = cache.get(input);

		if (u == null) {
			u = createStream(input).getUnit();
			cache.put(input, u);
		}

		return u;
	}

	public boolean isDebug() {
		return debug >= 0;
	}

	public void pushDebug() {
		debug++;
	}

	public void popDebug() {
		debug--;
	}

	public void debugInfo(String s) {
		if (debug >= 0) {
			if (debug >= 2) {
				System.out.println("  ".repeat(debug - 1) + s);
			} else {
				System.out.println(s);
			}
		}
	}

	public void debugInfo(String s, Collection<?> values) {
		debugInfo(s + ": " + values.stream().map(Object::toString).collect(Collectors.joining("  ")));
	}
}
