package org.hasan.hashcode;

public class ClassWithNoHashCode {
    private String value;

    public ClassWithNoHashCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object myClass) {
        ClassWithNoHashCode m = (ClassWithNoHashCode)myClass;
        return this.value.equals(m.getValue());
    }
}
