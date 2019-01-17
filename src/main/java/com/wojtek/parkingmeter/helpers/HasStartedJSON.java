package com.wojtek.parkingmeter.helpers;

import com.wojtek.parkingmeter.helpers.enums.HasStartedEnum;

public class HasStartedJSON {

    HasStartedEnum hasStarted;

    public HasStartedJSON(HasStartedEnum hasStarted) {
        this.hasStarted = hasStarted;
    }

    public HasStartedEnum getHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(HasStartedEnum hasStarted) {
        this.hasStarted = hasStarted;
    }
}
