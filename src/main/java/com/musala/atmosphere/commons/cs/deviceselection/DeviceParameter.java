// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

package com.musala.atmosphere.commons.cs.deviceselection;

/**
 * Interface representing a parameter by which a device can be described. All known parameters are described in the
 * {@link Visitor} interface.
 * 
 * @author vassil.angelov
 *
 */
public interface DeviceParameter {

    /**
     * Visitor that defines API for differentiating the various known implementations of {@link DeviceParameter}.
     * 
     * @author vassil.angelov
     *
     */
    public interface Visitor {
        void visit(ApiLevel.Minimum minApiLevel);

        void visit(ApiLevel.Maximum minApiLevel);

        void visit(ApiLevel.Target minApiLevel);

        void visit(DeviceOs deviceOs);

        void visit(DeviceType deviceType);

        void visit(SerialNumber serialNumber);

        void visit(DeviceModel deviceModel);

        void visit(ScreenParameter.Width screenWidth);

        void visit(ScreenParameter.Height screenHeight);

        void visit(ScreenParameter.DPI screenDpi);

        void visit(CameraAvailable cameraAvailable);

        void visit(RamCapacity ramCapacity);
    }

    void accept(Visitor visitor);

}
