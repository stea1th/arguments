package de.stea1th.program.flags;

public abstract class FlagBase<T> implements IFlag<T> {

    T value;

    public T getValue() {
        return value;
    }
}
