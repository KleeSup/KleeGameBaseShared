package de.kleesup.libraries.gamebase.shared.math;

import java.util.Optional;

public abstract class NumberParser<T extends Number> {

    /* -- Implementations -- */

    public static final NumberParser<Byte> BYTE = new NumberParser<Byte>() {
        @Override
        Byte func_parse(String str) {
            return Byte.parseByte(str);
        }
    };

    public static final NumberParser<Short> SHORT = new NumberParser<Short>() {
        @Override
        Short func_parse(String str) {
            return Short.parseShort(str);
        }
    };

    public static final NumberParser<Integer> INTEGER = new NumberParser<Integer>() {
        @Override
        Integer func_parse(String str) {
            return Integer.parseInt(str);
        }
    };

    public static final NumberParser<Long> LONG = new NumberParser<Long>() {
        @Override
        Long func_parse(String str) {
            return Long.parseLong(str);
        }
    };

    public static final NumberParser<Float> FLOAT = new NumberParser<Float>() {
        @Override
        Float func_parse(String str) {
            return Float.parseFloat(str);
        }
    };

    public static final NumberParser<Double> DOUBLE = new NumberParser<Double>() {
        @Override
        Double func_parse(String str) {
            return Double.parseDouble(str);
        }
    };

    /* -- Class structure -- */

    private NumberParser(){

    }

    public boolean isValid(String str){
        if(str == null)return false;
        try {
            func_parse(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public Optional<T> get(String str){
        if(str == null)return Optional.empty();
        try {
            return Optional.of(func_parse(str));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }

    abstract T func_parse(String str);

}
