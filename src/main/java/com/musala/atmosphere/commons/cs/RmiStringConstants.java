package com.musala.atmosphere.commons.cs;

public enum RmiStringConstants {
    /**
     * String, under which the {@link PoolManager PoolManager} class is published in the Agent's RMI registry
     */
    POOL_MANAGER("PoolManager");

    private String value;

    private RmiStringConstants(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
