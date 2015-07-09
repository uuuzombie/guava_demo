package com.sky.demo.qua.base;

import com.google.common.base.Objects;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


/**
 * <p>
 * Assists in implementing {@link Object#toString()} methods using reflection
 * </p>
 * 
 * <p>
 * This class uses reflection to determine the fields to append. Because these fields are usually private, the class can
 * use {@link java.lang.reflect.AccessibleObject#setAccessible(java.lang.reflect.AccessibleObject[], boolean)} to change
 * the visibility of the fields( This may fail under a security manager, But don't worry about this)
 * </p>
 * 
 * <p>
 * A typical invocation for this method would be like:
 * </p>
 * 
 * <code>
 *     public String toString() {
 *         return ReflectionToString.create().appendTransients(true).toString(this);
 *     }
 * </code>
 * 
 * <p>
 * You may find <code> org.apache.commons.lang3.builder.ReflectionToStringBuilder</code> can help you with this
 * </p>
 * 
 * @author sy
 */
@Exercise(name = "ReflectionToString", difficulty = Difficulty.NIGHT_MARE, related = Objects.ToStringHelper.class)
public class ReflectionToString {

    /**
     * Whether or not to append static fields.
     */
    private boolean appendStatics = false;

    /**
     * Whether or not to append transient fields.
     */
    private boolean appendTransients = false;

    protected ReflectionToString() {
    }

    public static ReflectionToString create() {
        return new ReflectionToString();
    }

    /**
     * @param outputTransients whether to include transient fields
     */
    public ReflectionToString appendTransients(boolean outputTransients) {
        this.appendTransients = outputTransients;
        return this;
    }

    /**
     * @param outputStatics whether to include static fields
     */
    public ReflectionToString appendStatics(boolean outputStatics) {
        this.appendStatics = outputStatics;
        return this;
    }

    public boolean isAppendStatics() {
        return appendStatics;
    }

    public boolean isAppendTransients() {
        return appendTransients;
    }

    public String toString(Object object) {
        // TODO implement this
        return null;
    }

    public String toStringExcludeFields(Object object, String... excludedFields) {
        // TODO implement this
        return null;
    }

}
