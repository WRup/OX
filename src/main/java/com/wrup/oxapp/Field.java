package com.wrup.oxapp;

import java.util.Objects;

/**
 * @author Wiktor Rup
 */
class Field {

    Sign fieldSign;

    Field(Sign fieldSign) {
        this.fieldSign = fieldSign;
    }

    Sign getFieldSign() {
        return fieldSign;
    }

    //TODO: auto-generated?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return fieldSign == field.fieldSign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldSign);
    }

    Field changeState(Sign stateToChange) {
        if ((fieldSign.equals(Sign.X) || fieldSign.equals(Sign.O)) && !stateToChange.equals(Sign.EMPTY)) {
            return new Field(fieldSign);
        } else
            return new Field(stateToChange);
    }

    //TODO: do we need method to forcing change of field if we have changeState()?
    void setFieldSign(Sign signToPut) {
        this.fieldSign = signToPut;
    }
}
