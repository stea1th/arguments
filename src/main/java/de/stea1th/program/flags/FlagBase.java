package de.stea1th.program.flags;

public abstract class FlagBase<T> implements IFlag<T> {

    protected T value;

    public T getValue() {
        return value;
    }
}
