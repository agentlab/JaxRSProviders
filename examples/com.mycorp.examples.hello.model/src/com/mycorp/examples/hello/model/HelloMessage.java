/*******************************************************************************
* Copyright (c) 2010 Composent, Inc. and others. All rights reserved. This
* program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution, and is
* available at http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Composent, Inc. - initial API and implementation
******************************************************************************/
package com.mycorp.examples.hello.model;


/**
 * @since 3.0
 */
public class HelloMessage {

	private String from;
	private String message;
	private int[] array = {1, 1, 2, 3, 5, 8, 13, 21};
	
	public HelloMessage(String from, String message) {
		this.from = from;
		this.message = message;
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getMessage() {
		return message;
	}

	/*public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelloMessage[from=");
		builder.append(from);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}*/
	
	public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
