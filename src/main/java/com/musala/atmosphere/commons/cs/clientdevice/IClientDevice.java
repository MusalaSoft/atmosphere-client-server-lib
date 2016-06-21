package com.musala.atmosphere.commons.cs.clientdevice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.cs.exception.DeviceNotFoundException;
import com.musala.atmosphere.commons.cs.exception.InvalidPasskeyException;
import com.musala.atmosphere.commons.exceptions.CommandFailedException;

/**
 * Common interface for the user's actions. Used in the RMI connection between Client and Server.
 * 
 * @author vladimir.vladimirov
 * 
 */

public interface IClientDevice extends Remote {
    /**
     * Requests an action invocation on the device wrapper.
     * 
     * @param invocationPasskey
     *        - the passkey that authorizes this invocation
     * @param action
     *        - a {@link RoutingAction} instance that specifies the action to be invoked
     * @param args
     *        - the action parameters (if required)
     * @return the result from the action invocation
     * @throws RemoteException
     *         thrown when the execution of a remotely called method fails for some reason - broken connection, missing
     *         method or something else
     * @throws CommandFailedException
     *         thrown when failed to execute action on the target device
     * @throws InvalidPasskeyException
     *         thrown when the passed passkey is not valid
     * @throws DeviceNotFoundException
     *         thrown when an action fails, because the server fails to find the target device
     */
    public Object route(long invocationPasskey, RoutingAction action, Object... args)
        throws RemoteException,
            CommandFailedException,
            InvalidPasskeyException,
            DeviceNotFoundException;

}
