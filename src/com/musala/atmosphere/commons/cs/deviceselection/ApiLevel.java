package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * Describes {@link DeviceParameter} related to the Android SDK API of a device.
 * 
 * @author vassil.angelov
 *
 */
public abstract class ApiLevel extends SingleValueDeviceParameter<Integer> {

    private static final long serialVersionUID = -7192304287970591453L;

    /**
     * The maximum API a device can have.
     * 
     * @author vassil.angelov
     *
     */
    public static class Maximum extends ApiLevel {
        private static final long serialVersionUID = 4799108544546282115L;

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

        private static final long serialVersionUID = 924163466017913930L;

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
        private static final long serialVersionUID = 7748774722618853196L;

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Target(int apiLevel) {
            value = apiLevel;
        }
    }

}
