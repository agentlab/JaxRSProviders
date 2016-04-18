/****************************************************************************
 * Copyright (c) 2009 Composent, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Composent, Inc. - initial API and implementation
 *****************************************************************************/
package com.mycorp.examples.hello;

import com.mycorp.examples.hello.model.HelloMessage;

public interface IHello {
	
	public String hello();
	
	public HelloMessage hello2();

	public HelloMessage hello3(String from);
	
	public HelloMessage hello4(HelloMessage message);
}
