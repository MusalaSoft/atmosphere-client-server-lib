package com.musala.atmosphere.commons.cs.clientdevice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.cs.InvalidPasskeyException;
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
     *        - the passkey that authorizes this invocation.
     * @param action
     *        - a {@link RoutingAction} instance that specifies the action to be invoked.
     * @param args
     *        - the action parameters (if required).
     * @return the result from the action invocation.
     * @throws RemoteException
     * @throws CommandFailedException
     * @throws InvalidPasskeyException
     */
    public Object route(long invocationPasskey, RoutingAction action, Object... args)
        throws RemoteException,
            CommandFailedException,
            InvalidPasskeyException;

}
