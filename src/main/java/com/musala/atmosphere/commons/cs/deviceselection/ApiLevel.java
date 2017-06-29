package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * Describes {@link DeviceParameter} related to the Android SDK API of a device.
 *
 * @author vassil.angelov
 *
 */
public abstract class ApiLevel extends SingleValueDeviceParameter<Integer> {
    /**
     * The maximum API a device can have.
     *
     * @author vassil.angelov
     *
     */
    public static class Maximum extends ApiLevel {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Maximum(int apiLevel) {
            value = apiLevel;
        }
    }

    /**
     * The minimum API a device can have.
     *
     * @author vassil.angelov
     *
     */
    public static class Minimum extends ApiLevel {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Minimum(int apiLevel) {
            value = apiLevel;
        }
    }

    /**
     * The targeted API a device can have. In case this parameter is present along with both (or one of)
     * {@link ApiLevel.Maximum} or {@link ApiLevel.Minimum}, the target is considered with higher priority.
     *
     * @author vassil.angelov
     *
     */
    public static class Target extends ApiLevel {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Target(int apiLevel) {
            value = apiLevel;
        }
    }

}
