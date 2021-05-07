package com.example.demo.designpatterns.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectFactory {

    private final Map<String, StateObject> stateCache = new ConcurrentHashMap<>();

    public FlyweightObject createFlyweightObject(String intrinsicStateKey, int extrinsicState ) {
        StateObject intrinsicState = stateCache.computeIfAbsent(intrinsicStateKey, StateObject::new);
        return new FlyweightObject(intrinsicState, extrinsicState);
    }
}
