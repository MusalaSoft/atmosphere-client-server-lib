package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * Describes {@link DeviceParameter} related to the screen of a device.
 * 
 * @author vassil.angelov
 *
 */
public abstract class ScreenParameter extends SingleValueDeviceParameter<Integer> {
    /**
     * The width in pixels of a device`s screen represented as a {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public static class Width extends ScreenParameter {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Width(int width) {
            value = width;
        }

    }

    /**
     * The height in pixels of a device`s screen represented as a {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public static class Height extends ScreenParameter {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        Height(int height) {
            value = height;
        }
    }

    /**
     * The DPI of a device`s screen represented as a {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public static class DPI extends ScreenParameter {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        DPI(int dpi) {
            value = dpi;
        }

    }
}
