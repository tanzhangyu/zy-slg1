package com.zy.common.mq;

import com.zy.common.core.ZyException;

@FunctionalInterface
public interface PlayerHandler<A, B, C> {
	A _handler(B b, C c) throws ZyException;
}
